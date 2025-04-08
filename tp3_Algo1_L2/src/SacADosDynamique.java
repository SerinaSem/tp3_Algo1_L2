public class SacADosDynamique {
    public static int resoudre(Instance instance) {
        int n = instance.objets.size();
        int capacite = instance.capacite;
        int[][] dp = new int[n + 1][capacite + 1];

        for (int i = 1; i <= n; i++) {
            Objet obj = instance.objets.get(i - 1);
            for (int w = 0; w <= capacite; w++) {
                if (obj.poids <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - obj.poids] + obj.valeur);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Valeur maximale atteinte
        int valeurMax = dp[n][capacite];

        // Afficher les objets sélectionnés (backtrack)
        System.out.println("Objets sélectionnés :");
        int w = capacite;
        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                Objet obj = instance.objets.get(i - 1);
                System.out.println("Poids: " + obj.poids + ", Valeur: " + obj.valeur);
                w -= obj.poids;
            }
        }

        return valeurMax;
    }
}
