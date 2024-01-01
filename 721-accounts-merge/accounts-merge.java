/*

["David","David0@m.co","David1@m.co"]
["David","David3@m.co","David4@m.co"]
["David","David4@m.co","David5@m.co"]
["David","David2@m.co","David3@m.co"]
["David","David1@m.co","David2@m.co"]

*/
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Account> emailsToMergedAccounts = new HashMap<>();

        for (List<String> accountList : accounts) {
            System.out.println("Processing " + accountList);
            Set<Account> existingAccountsSet = new HashSet<>();
            for (int i = 1; i < accountList.size(); i++) {
                if (emailsToMergedAccounts.containsKey(accountList.get(i))) {
                    existingAccountsSet.add(emailsToMergedAccounts.get(accountList.get(i)));
                }
            }

            List<Account> existingAccounts = new ArrayList<>(existingAccountsSet);

            if (existingAccounts.size() > 1) {
                Account firstAccount = existingAccounts.get(0);
                for (int i = 1; i < existingAccounts.size(); i++) {
                    for (String email : existingAccounts.get(i).emails) {
                        firstAccount.emails.add(email);
                        emailsToMergedAccounts.put(email, firstAccount);
                    }
                }
            }

            Account account;
            if (!existingAccounts.isEmpty()) {
                account = existingAccounts.get(0);
            } else {
                account = new Account();
                account.name = accountList.get(0);
                account.emails = new HashSet<>();
            }

            for (int i = 1; i < accountList.size(); i++) {
                account.emails.add(accountList.get(i));
                emailsToMergedAccounts.put(accountList.get(i), account);
            }
        }

        List<List<String>> mergedAccounts = new ArrayList<>();

        List<Account> mergedAccountValues = new ArrayList<>(new HashSet<>(emailsToMergedAccounts.values()));

        for (Account account : mergedAccountValues) {
            List<String> emailsSorted = new ArrayList<>(account.emails);
            Collections.sort(emailsSorted);
            
            List<String> accountList = new ArrayList<>();
            accountList.add(account.name);
            accountList.addAll(emailsSorted);

            mergedAccounts.add(accountList);
        }

        return mergedAccounts;
    }

    private static class Account {
        String name;
        Set<String> emails;
    }
}