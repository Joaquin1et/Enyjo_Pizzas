
package enyjopizza;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author joaqu
 */
public class EnyjoPizza extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        
        
        Parent root = FXMLLoader.load(getClass().getResource("/view/EnyjoPizza.fxml"));
        
        Scene scene = new Scene(root);
        
        /*stage.initStyle(StageStyle.UNDECORATED);*/
        stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
