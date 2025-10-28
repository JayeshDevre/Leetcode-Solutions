class Solution {
    public int bestClosingTime(String customers) {
        int penalty = 0;
        int minPenalty = 0;
        int bestHour = 0;

        // Initially, assume shop is open all hours
        // Count all 'Y' as penalty (since closing at hour 0 means you missed all)
        for (char c : customers.toCharArray()) {
            if (c == 'Y') penalty++;
        }

        minPenalty = penalty;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                // Staying open for 'Y' removes a missed penalty
                penalty--;
            } else {
                // Staying open for 'N' adds a wasted penalty
                penalty++;
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i + 1;
            }
        }

        return bestHour;
    }
}
