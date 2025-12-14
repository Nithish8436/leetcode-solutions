import java.util.*;

class Solution {
    public List<String> validateCoupons(
            String[] code,
            String[] businessLine,
            boolean[] isActive) {

        List<Coupon> validCoupons = new ArrayList<>();

        // allowed business categories
        Set<String> validBusiness = new HashSet<>(
                Arrays.asList("electronics", "grocery", "pharmacy", "restaurant")
        );

        // regex for valid code
        String pattern = "^[a-zA-Z0-9_]+$";

        for (int i = 0; i < code.length; i++) {

            // condition 1: code validation
            if (code[i] == null || code[i].isEmpty() || !code[i].matches(pattern))
                continue;

            // condition 2: businessLine validation
            if (!validBusiness.contains(businessLine[i]))
                continue;

            // condition 3: active check
            if (!isActive[i])
                continue;

            validCoupons.add(new Coupon(code[i], businessLine[i]));
        }

        // sort by businessLine first, then by code
        Collections.sort(validCoupons, (a, b) -> {
            if (!a.businessLine.equals(b.businessLine))
                return a.businessLine.compareTo(b.businessLine);
            return a.code.compareTo(b.code);
        });

        // extract codes
        List<String> result = new ArrayList<>();
        for (Coupon c : validCoupons) {
            result.add(c.code);
        }

        return result;
    }

    // helper class
    static class Coupon {
        String code;
        String businessLine;

        Coupon(String code, String businessLine) {
            this.code = code;
            this.businessLine = businessLine;
        }
    }
}