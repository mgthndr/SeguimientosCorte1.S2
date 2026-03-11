import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Genera todas las texturas PNG para el juego en la carpeta images/.
 * Ejecutar una sola vez para pre-generar los assets.
 */
public class GenerateTextures {
    private static final int TILE_SIZE = 40;
    private static final String IMAGES_DIR = "images";
    
    public static void main(String[] args) throws Exception {
        // Crear directorio si no existe
        File dir = new File(IMAGES_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
            System.out.println("Created images directory");
        }
        
        System.out.println("Generating textures...");
        
        // Bloques básicos
        saveImage(createBlockTexture(), "block.png");
        saveImage(createMetaTexture(), "meta.png");
        saveImage(createPlayerTexture(), "player.png");
        saveImage(createCheckpointTexture(), "checkpoint.png");
        
        // Spikes - Normal rotación (0, 90, 180, 270 grados)
        for (int i = 0; i < 4; i++) {
            int rotation = i * 90;
            saveImage(createSpikeTextureRotated(rotation), "spike_" + rotation + ".png");
        }
        
        // Trap Spikes - Rotación (0, 90, 180, 270 grados)
        for (int i = 0; i < 4; i++) {
            int rotation = i * 90;
            saveImage(createTrapSpikeTextureForGame(true, rotation), "trap_spike_active_" + rotation + ".png");
        }
        
        // Phantom blocks
        saveImage(createPhantomBlockTexture(true), "phantom_active.png");
        saveImage(createPhantomBlockTexture(false), "phantom_inactive.png");
        
        // Colored blocks
        saveImage(createColoredBlock("#FFD700"), "block_yellow.png");
        saveImage(createColoredBlock("#3498DB"), "block_blue.png");
        saveImage(createColoredBlock("#2ECC71"), "block_green.png");
        saveImage(createColoredBlock("#9B59B6"), "block_purple.png");
        
        // Decorations
        saveImage(createDecoTexture(4), "deco_plant.png");
        saveImage(createDecoTexture(5), "deco_rock.png");
        saveImage(createDecoTexture(6), "deco_cloud.png");
        saveImage(createDecoTexture(7), "deco_tree.png");
        saveImage(createDecoTexture(8), "deco_flower.png");
        saveImage(createDecoTexture(9), "deco_water.png");
        
        System.out.println("All textures generated successfully!");
    }
    
    private static void saveImage(BufferedImage img, String filename) throws Exception {
        File file = new File(IMAGES_DIR, filename);
        ImageIO.write(img, "PNG", file);
        System.out.println("  ✓ " + filename);
    }
    
    private static BufferedImage createBlockTexture() {
        BufferedImage img = new BufferedImage(TILE_SIZE, TILE_SIZE, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(Color.decode("#8B4513"));
        g2d.fillRect(0, 0, TILE_SIZE, TILE_SIZE);
        
        g2d.setColor(Color.decode("#654321"));
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(0, 0, TILE_SIZE - 1, TILE_SIZE - 1);
        
        g2d.setColor(new Color(139, 69, 19, 100));
        g2d.fillRect(5, 5, 10, 10);
        g2d.fillRect(25, 15, 10, 10);
        g2d.fillRect(15, 28, 8, 8);
        
        g2d.dispose();
        return img;
    }
    
    private static BufferedImage createSpikeTextureRotated(int rotation) {
        BufferedImage img = new BufferedImage(TILE_SIZE, TILE_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setComposite(AlphaComposite.Clear);
        g2d.fillRect(0, 0, TILE_SIZE, TILE_SIZE);
        g2d.setComposite(AlphaComposite.SrcOver);
        
        g2d.translate(TILE_SIZE / 2, TILE_SIZE / 2);
        g2d.rotate(Math.toRadians(rotation));
        g2d.translate(-TILE_SIZE / 2, -TILE_SIZE / 2);
        
        int[] xPoints = {20, 0, 40};
        int[] yPoints = {0, 40, 40};
        g2d.setColor(Color.RED);
        g2d.fillPolygon(xPoints, yPoints, 3);
        
        g2d.setColor(Color.decode("#CC0000"));
        g2d.setStroke(new BasicStroke(2));
        g2d.drawPolygon(xPoints, yPoints, 3);
        
        g2d.dispose();
        return img;
    }
    
    private static BufferedImage createTrapSpikeTextureForGame(boolean activated, int rotation) {
        BufferedImage img = new BufferedImage(TILE_SIZE, TILE_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setComposite(AlphaComposite.Clear);
        g2d.fillRect(0, 0, TILE_SIZE, TILE_SIZE);
        g2d.setComposite(AlphaComposite.SrcOver);
        
        g2d.translate(TILE_SIZE / 2, TILE_SIZE / 2);
        g2d.rotate(Math.toRadians(rotation));
        g2d.translate(-TILE_SIZE / 2, -TILE_SIZE / 2);
        
        int[] xPoints = {20, 0, 40};
        int[] yPoints = {0, 40, 40};
        
        if (activated) {
            g2d.setColor(Color.decode("#FF1493"));
            g2d.fillPolygon(xPoints, yPoints, 3);
            g2d.setColor(Color.decode("#CC0066"));
            g2d.setStroke(new BasicStroke(2));
            g2d.drawPolygon(xPoints, yPoints, 3);
        } else {
            g2d.setColor(new Color(255, 100, 100, 20));
            g2d.fillPolygon(xPoints, yPoints, 3);
            g2d.setColor(new Color(200, 50, 50, 30));
            g2d.setStroke(new BasicStroke(1));
            g2d.drawPolygon(xPoints, yPoints, 3);
        }
        
        g2d.dispose();
        return img;
    }
    
    private static BufferedImage createPhantomBlockTexture(boolean activated) {
        BufferedImage img = new BufferedImage(TILE_SIZE, TILE_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if (activated) {
            g2d.setColor(Color.decode("#4A4A4A"));
            g2d.fillRect(0, 0, TILE_SIZE, TILE_SIZE);
            g2d.setColor(Color.decode("#2A2A2A"));
            g2d.setStroke(new BasicStroke(2));
            g2d.drawRect(0, 0, TILE_SIZE - 1, TILE_SIZE - 1);
        } else {
            g2d.setColor(new Color(74, 74, 74, 80));
            g2d.fillRect(0, 0, TILE_SIZE, TILE_SIZE);
            g2d.setColor(new Color(42, 42, 42, 100));
            g2d.setStroke(new BasicStroke(2));
            g2d.drawRect(0, 0, TILE_SIZE - 1, TILE_SIZE - 1);
            
            for (int i = 0; i < TILE_SIZE; i += 10) {
                g2d.drawLine(i, i, i + 10, i + 10);
            }
        }
        
        g2d.dispose();
        return img;
    }
    
    private static BufferedImage createMetaTexture() {
        BufferedImage img = new BufferedImage(TILE_SIZE, TILE_SIZE, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(Color.decode("#FFD700"));
        g2d.fillRect(0, 0, TILE_SIZE, TILE_SIZE);
        
        g2d.setColor(Color.decode("#FFA500"));
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRect(3, 3, TILE_SIZE - 6, TILE_SIZE - 6);
        
        g2d.drawLine(8, 15, 32, 15);
        g2d.drawLine(8, 25, 32, 25);
        
        g2d.dispose();
        return img;
    }
    
    private static BufferedImage createPlayerTexture() {
        BufferedImage img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(Color.RED);
        g2d.fillRect(0, 0, 16, 16);
        
        g2d.setColor(Color.decode("#CC0000"));
        g2d.setStroke(new BasicStroke(1));
        g2d.drawRect(0, 0, 15, 15);
        
        g2d.setColor(Color.WHITE);
        g2d.fillRect(2, 4, 3, 3);
        g2d.fillRect(11, 4, 3, 3);
        
        g2d.dispose();
        return img;
    }
    
    private static BufferedImage createCheckpointTexture() {
        BufferedImage img = new BufferedImage(TILE_SIZE, TILE_SIZE, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(Color.decode("#FFD700"));
        g2d.fillRect(0, 0, TILE_SIZE, TILE_SIZE);
        
        g2d.setColor(Color.decode("#FFA500"));
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRect(0, 0, TILE_SIZE - 1, TILE_SIZE - 1);
        
        g2d.setColor(Color.RED);
        g2d.fillRect(15, 10, 10, 15);
        
        g2d.dispose();
        return img;
    }
    
    private static BufferedImage createColoredBlock(String hexColor) {
        BufferedImage img = new BufferedImage(TILE_SIZE, TILE_SIZE, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(Color.decode(hexColor));
        g2d.fillRect(0, 0, TILE_SIZE, TILE_SIZE);
        
        g2d.setColor(Color.decode(darkenHex(hexColor)));
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(0, 0, TILE_SIZE - 1, TILE_SIZE - 1);
        
        g2d.setColor(new Color(255, 255, 255, 50));
        g2d.fillRect(5, 5, 10, 10);
        g2d.fillRect(25, 25, 10, 10);
        
        g2d.dispose();
        return img;
    }
    
    private static BufferedImage createDecoTexture(int type) {
        BufferedImage img = new BufferedImage(TILE_SIZE, TILE_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        switch (type) {
            case 4: // Planta
                g2d.setColor(Color.decode("#2D5016"));
                g2d.fillRect(15, 30, 10, 10);
                g2d.setColor(Color.decode("#4CAF50"));
                g2d.fillPolygon(new int[]{20, 15, 20, 25}, new int[]{25, 30, 30, 30}, 4);
                break;
            case 5: // Roca
                g2d.setColor(Color.decode("#666666"));
                g2d.fillRect(8, 20, 24, 20);
                g2d.setColor(Color.decode("#999999"));
                g2d.fillRect(10, 22, 8, 8);
                g2d.fillRect(22, 28, 6, 6);
                break;
            case 6: // Nube
                g2d.setColor(Color.WHITE);
                g2d.fillOval(5, 5, 12, 8);
                g2d.fillOval(13, 3, 14, 10);
                g2d.fillOval(24, 6, 11, 8);
                break;
            case 7: // Árbol
                g2d.setColor(Color.decode("#8B4513"));
                g2d.fillRect(16, 25, 8, 15);
                g2d.setColor(Color.decode("#228B22"));
                g2d.fillOval(8, 12, 24, 18);
                break;
            case 8: // Flor
                g2d.setColor(Color.decode("#32CD32"));
                g2d.fillRect(18, 25, 4, 15);
                g2d.setColor(Color.RED);
                g2d.fillOval(15, 10, 10, 10);
                g2d.setColor(Color.YELLOW);
                g2d.fillOval(17, 12, 6, 6);
                break;
            case 9: // Agua
                g2d.setColor(Color.decode("#1E90FF"));
                g2d.fillRect(0, 20, TILE_SIZE, TILE_SIZE - 20);
                g2d.setColor(Color.CYAN);
                for (int i = 0; i < TILE_SIZE; i += 8) {
                    g2d.drawLine(i, 23, i + 4, 25);
                }
                break;
        }
        
        g2d.dispose();
        return img;
    }
    
    private static String darkenHex(String hex) {
        int color = Integer.parseInt(hex.substring(1), 16);
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;
        r = Math.max(0, r - 60);
        g = Math.max(0, g - 60);
        b = Math.max(0, b - 60);
        return String.format("#%02X%02X%02X", r, g, b);
    }
}
