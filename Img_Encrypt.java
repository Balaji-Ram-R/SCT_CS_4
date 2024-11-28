import java.awt.image.BufferedImage; // Represents an image present in memory
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Scanner;
//import java.nio.file.Files;
public class Img_Encrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Encrypt\n2 - Decrypt");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
            try {
                System.out.println("Enter the Path of Image: ");
                sc.nextLine();
                String path = sc.nextLine();
                System.out.println("Enter the key value to shift: ");
                int key = sc.nextInt();
                //creating a file object to store the path to the image
                File imgf = new File(path);
                //Load the imag into memory in the form of buffer
                BufferedImage bi = ImageIO.read(imgf);
                //creating a bytearray to store image in binary format
                ByteArrayOutputStream arr = new ByteArrayOutputStream();
                //writing the buffered image to the byte array
                ImageIO.write(bi,"jpg", arr);
                //making sure to write all the contents into byte array
                arr.flush();
                //converting image into binary form and storing in byte array
                byte[] img_bytes = arr.toByteArray();
                //closing to release system resources
                arr.close();
                // Read the original file into a byte array
                //byte[] imageBytes = Files.readAllBytes(originalFile.toPath());
                
                //Image Encryption and storing it into same byte array
                for (int i = 0; i < img_bytes.length; i++) {
                    img_bytes[i]^=key;
                }
                FileOutputStream fos = new FileOutputStream(imgf);
                fos.write(img_bytes);
                fos.close();
                System.out.println("Image Encrypted successfully");
    
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            break;
            
            case 2:

            try {

            // Input: Path of the encrypted image file
            System.out.println("Enter the Path of Encrypted Image: ");
            sc.nextLine();
            String path = sc.nextLine();

            // Input: Key used for encryption
            System.out.println("Enter the key value used to shift: ");
            int key = sc.nextInt();
            sc.close();

            // Read the encrypted image as a byte array
            File encryptedFile = new File(path);
            FileInputStream fis = new FileInputStream(encryptedFile);
            byte[] img_bytes = fis.readAllBytes(); // Read the entire encrypted file
            fis.close();

            // Decrypt the byte array by XORing with the key
            for (int i = 0; i < img_bytes.length; i++) {
                img_bytes[i] ^= key;
            }

            // Save the decrypted image to a new file
            File decryptedFile = new File(path);
            FileOutputStream fos = new FileOutputStream(decryptedFile);
            fos.write(img_bytes);
            fos.close();

            System.out.println("Image Decrypted successfully! "+decryptedFile.getAbsolutePath());

            } catch (Exception e) {
                e.printStackTrace();
            }

            break;
        
            default:
                break;
        }
        
    }
}
