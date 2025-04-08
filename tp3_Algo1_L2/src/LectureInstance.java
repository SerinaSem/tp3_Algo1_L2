import java.io.*;
import java.util.*;

public class LectureInstance {
    public static Instance lireFichier(String chemin) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(chemin));
        int capacite = Integer.parseInt(br.readLine().trim());
        List<Objet> objets = new ArrayList<>();

        String ligne;
        while ((ligne = br.readLine()) != null) {
            String[] parts = ligne.trim().split("\\s+");
            int poids = Integer.parseInt(parts[0]);
            int valeur = Integer.parseInt(parts[1]);
            objets.add(new Objet(poids, valeur));
        }

        br.close();
        return new Instance(capacite, objets);
    }
}
