
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import modelo.Carro;

/**
 *
 * @author Estudiante
 */

public class LoopJuego extends AnimationTimer{
    private GraphicsContext lapiz;
    private Carro carro;
    private Image fondo;
    private Image fondo2;
    private Image gato;
    private Image tipo_left;
    private int c = 0;
    private int m = 1;
    private int p = 0;
    private int F = 1024;

    public LoopJuego(GraphicsContext lapiz) {
        this.lapiz = lapiz;
        this.carro = new Carro(0, 100, 20, 20);
        this.fondo = new Image("image/fondo.png");
        this.fondo2 = new Image("image/fondo.png");
        this.gato = new Image("image/cats.gif"); 
        this.tipo_left = new Image("image/left0.png"); 
        this.c = c;
        this.F = F;
    }
    
    
    
    @Override
    public void handle(long now) {
         //Carro
         
        lapiz.clearRect(0, 0, 300, 300);
        lapiz.drawImage(this.fondo, this.F-1024, 0);
        lapiz.drawImage(this.fondo2, this.F, 0);
        if(F <= 0){
            F = 1024;
        }
        else
        {
            F-=2;
        }
        lapiz.drawImage(this.gato, (132*c), 0, 132, 80, 150 + m, 320, 132, 80);
        //lapiz.drawImage(this.gato, (132 * c), 0, 132, 80, 170, 20, 132, 80);
        m++;
        
        lapiz.drawImage(this.tipo_left, 800, 370);
        //lapiz.fillRect(170, this.carro.getYref(), 50, 50);
        //lapiz.strokeRect(this.carro.getXref(), this.carro.getYref(), this.carro.getAncho(), this.carro.getAlto());
        lapiz.strokeText("Puntaje: " + p, 200, 10);
        
        Shape Rectangulo1 = new Rectangle (0, 0, 132, 80);
        Shape Rectangulo2 = new Rectangle (30, 39, 800, 370);
        Shape Interseccion = SVGPath.intersect(Rectangulo1, Rectangulo2);
        if(Interseccion.getBoundsInLocal().getWidth() != -1){
            p+= 10;
        }
        this.carro.mover();
        if(c == 5){
            c = 0;
        }
        else{
            c++;
        }
    }
}
