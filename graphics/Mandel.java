import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Mandel {
	
	int MAX_X = 1000;
	int MAX_Y = 1000;
	
	public static void main(String[] args) {
		new Mandel();
	}
	
	public Mandel() {
		BufferedImage img = new BufferedImage(MAX_X, MAX_Y, BufferedImage.TYPE_INT_ARGB);
		for(int i = 0; i < MAX_X;i++) {
			if(i%100==0)
				System.out.println("Row " + i +" done");
			for(int j = 0; j < MAX_Y; j++) {
				img.setRGB(i, j, getColor(i,j));
			}
		}
		System.out.println("We here");
		File f = new File("Image.png");
		try {
			ImageIO.write(img, "png", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	int getColor(int x, int y) {
		double real = map(x,0,MAX_X,-2,1);
		double imag = map(y,0,MAX_Y,-1.5,1.5);
		ComplexNumber point = new ComplexNumber(real, imag);
		if(getsBig(point)) {
			return getColorInt(0,0,255-howBig(point),255);
		} else {
			return getColorInt(0,0,0,255);
		}
	}
	
	boolean getsBig(ComplexNumber n) {
		ComplexNumber c = new ComplexNumber(n.real, n.img);
		for(int i=0; i<100; i++) {
			n = runFunction(n,c);
		}
		
		if(n.getMag() <= 2) {
			return false;
		}
		
		return true;
	}
	
	int howBig(ComplexNumber n) {
		ComplexNumber c = new ComplexNumber(n.real, n.img);
		for(int i=0; i<5; i++) {
			n = runFunction(n,c);
		}
		double mag = n.getMag();
		return (int)mag;
	}
	
	ComplexNumber runFunction(ComplexNumber z, ComplexNumber c) {
		ComplexNumber f = z.mult(z);
		f = f.add(c);
		return f;
	}
	
	double map(double x, double in_min, double in_max, double out_min, double out_max) {
		return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
	}
	
	int getColorInt(int r, int g, int b, int alpha) {
		return (alpha << 24) | (r << 16) | (g << 8) | b;
	}
	

}

class ComplexNumber {
	
	double real;
	double img;
	
	public ComplexNumber(double real, double img) {
		this.real = real;
		this.img = img;
	}
	
	public ComplexNumber add(ComplexNumber n) {
		return new ComplexNumber(real + n.real, img + n.img);
	}
	
	public ComplexNumber sub(ComplexNumber n) {
		return new ComplexNumber(real - n.real, img - n.img);
	}
	
	public ComplexNumber mult(ComplexNumber n) {
		double newreal = real * n.real - img * n.img;
        double newimag = real * n.img + img * n.real;
        return new ComplexNumber(newreal, newimag);
	}
	
	public double getMag() {
		return Math.sqrt(real*real + img*img);
	}
}