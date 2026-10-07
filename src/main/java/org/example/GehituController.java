
package org.example;

public class GehituController {
    private Babeslekua model;
    private GehituView view;
    private SceneManager sceneManager;

    public GehituController(Babeslekua model, GehituView view, SceneManager sceneManager) {
        this.model = model;
        this.view = view;
        this.sceneManager = sceneManager;
    }

    public void gorde() {
        try {
            String izena = view.getIzena().trim();
            if (izena.isEmpty()) {
                view.erakutsiErrorea("Izena ezin da hutsik egon.");
                return;
            }
            if (model.bilatuAnimalia(izena) != null) {
                view.erakutsiErrorea("Izen hori duen animalia bat badago jada.");
                return;
            }

            int adina = Integer.parseInt(view.getAdina().trim());
            double pisua = Double.parseDouble(view.getPisua().trim());
            String mota = view.getMota();

            Animalia animalia = switch (mota) {
                case "Txakurra" -> new Txakurra(izena, adina, pisua);
                case "Katua" -> new Katua(izena, adina, pisua);
                default -> new Untxia(izena, adina, pisua);
            };

            model.gehituAnimalia(animalia);

            // Volver al inicio con mensaje de éxito
            sceneManager.erakutsiNagusia(animalia.getIzena() + " ongi gehitu da sistemara.\n");

        } catch (NumberFormatException ex) {
            view.erakutsiErrorea("Adina eta Pisua eremuak zenbakiak izan behar dira.");
        }
    }

    public void utzi() {
        sceneManager.erakutsiNagusia(null);
    }
}