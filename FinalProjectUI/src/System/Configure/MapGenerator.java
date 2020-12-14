package System.Configure;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Bohan Feng
 */
public class MapGenerator {

    public static void CreateMap(String latitude, String longitude, JLabel holder, int width, int height, int zoom) {
        String destinationFile = "./image/map/map("+latitude+"-"+longitude+")"+width +"x"+ height +".jpg";
        try {

            String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="
                    + latitude
                    + ","
                    + longitude
                    + "&zoom="
                    + zoom 
                    + "&size="+width +"x"+ height +"&scale=2&maptype=roadmap&key=AIzaSyCt03t92M6HcTAHZIbXWhA_YGtSgOI_fZg";

            // read the map image from Google
            // then save it to a local file: image.jpg
            //
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // create a GUI component that loads the image: image.jpg
        //
        ImageIcon imageIcon = new ImageIcon((new ImageIcon(destinationFile))
                .getImage().getScaledInstance(width, height,
                        java.awt.Image.SCALE_SMOOTH));
        holder.setText("");
        holder.setIcon(imageIcon);
    }

}
