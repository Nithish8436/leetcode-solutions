import os
import requests
from datetime import datetime
from github import Github

# --------------------------
# ENVIRONMENT VARIABLES (from GitHub Secrets)
# --------------------------
LEETCODE_SESSION = os.getenv("LEETCODE_SESSION")
CSRFTOKEN = os.getenv("CSRFTOKEN")
GITHUB_TOKEN = os.getenv("GITHUB_TOKEN")
REPO_NAME = os.getenv("GITHUB_REPOSITORY")  # auto-available in GitHub Actions

# --------------------------
# HEADERS
# --------------------------
HEADERS = {
    "Cookie": f"LEETCODE_SESSION={LEETCODE_SESSION}; csrftoken={CSRFTOKEN}",
    "x-csrftoken": CSRFTOKEN,
    "Referer": "https://leetcode.com/",
    "User-Agent": "Mozilla/5.0",
}

# --------------------------
# FETCH RECENT ACCEPTED SUBMISSIONS
# --------------------------
def fetch_recent_submissions(limit=5):
    url = f"https://leetcode.com/api/submissions/?offset=0&limit={limit}"
    response = requests.get(url, headers=HEADERS)
    response.raise_for_status()
    data = response.json()

    accepted = [s for s in data["submissions_dump"] if s["status_display"] == "Accepted"]
    return accepted

# --------------------------
# SAVE CODE TO GITHUB
# --------------------------
def push_to_github(submissions):
    g = Github(GITHUB_TOKEN)
    repo = g.get_repo(REPO_NAME)

    for sub in submissions:
        title = sub["title"].replace(" ", "_")
        lang = sub["lang"]
        code = sub["code"]
        ext = {"python3": "py", "java": "java", "cpp": "cpp"}.get(lang, "txt")
        folder = f"solutions/{lang}"
        filename = f"{folder}/{title}.{ext}"

        # Create or update file
        try:
            contents = repo.get_contents(filename)
            repo.update_file(contents.path, f"update: {title}", code, contents.sha)
            print(f"Updated {filename}")
        except:
            repo.create_file(filename, f"add: {title}", code)
            print(f"Added {filename}")

# --------------------------
# MAIN
# --------------------------
def main():
    print("Fetching accepted submissions...")
    submissions = fetch_recent_submissions(10)
    if submissions:
        push_to_github(submissions)
    else:
        print("No new accepted submissions found.")

if __name__ == "__main__":
    main()
