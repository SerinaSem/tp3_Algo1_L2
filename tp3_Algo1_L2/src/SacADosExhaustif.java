
import java.util.ArrayList;
import java.util.List;

public class SacADosExhaustif {
    private static int meilleurProfit;
    private static List<Objet> meilleureCombinaison;

    public static int resoudre(Instance instance) {
        meilleurProfit = 0;
        meilleureCombinaison = new ArrayList<>();
        explore(0, 0, 0, new ArrayList<>(), instance);
        
        // Afficher la meilleure combinaison
        System.out.println("Objets sélectionnés :");
        for (Objet o : meilleureCombinaison) {
            System.out.println("Poids: " + o.poids + ", Valeur: " + o.valeur);
        }

        return meilleurProfit;
    }

    private static void explore(int i, int poidsActuel, int valeurActuelle, List<Objet> selectionActuelle, Instance instance) {
        if (poidsActuel > instance.capacite) {
            return;
        }

        if (i == instance.objets.size()) {
            if (valeurActuelle > meilleurProfit) {
                meilleurProfit = valeurActuelle;
                meilleureCombinaison = new ArrayList<>(selectionActuelle);
            }
            return;
        }

        // Ne pas prendre l'objet i
        explore(i + 1, poidsActuel, valeurActuelle, selectionActuelle, instance);

        // Prendre l'objet i
        Objet obj = instance.objets.get(i);
        selectionActuelle.add(obj);
        explore(i + 1, poidsActuel + obj.poids, valeurActuelle + obj.valeur, selectionActuelle, instance);
        selectionActuelle.remove(selectionActuelle.size() - 1); // backtracking
    }
}

