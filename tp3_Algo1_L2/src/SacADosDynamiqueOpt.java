public class SacADosDynamiqueOpt {
    public static int resoudre(Instance instance) {
        int n = instance.objets.size();
        int capacite = instance.capacite;
        int[] dp = new int[capacite + 1];
        boolean[][] trace = new boolean[n][capacite + 1];

        for (int i = 0; i < n; i++) {
            Objet obj = instance.objets.get(i);
            // Parcours en arrière pour ne pas écraser les anciennes valeurs
            for (int w = capacite; w >= obj.poids; w--) {
                int nouvelleValeur = dp[w - obj.poids] + obj.valeur;
                if (nouvelleValeur > dp[w]) {
                    dp[w] = nouvelleValeur;
                    trace[i][w] = true;
                }
            }
        }

        // Backtrack pour retrouver les objets utilisés
        System.out.println("Objets sélectionnés :");
        int w = capacite;
        for (int i = n - 1; i >= 0; i--) {
            if (trace[i][w]) {
                Objet obj = instance.objets.get(i);
                System.out.println("Poids: " + obj.poids + ", Valeur: " + obj.valeur);
                w -= obj.poids;
            }
        }

        return dp[capacite];
    }
}
