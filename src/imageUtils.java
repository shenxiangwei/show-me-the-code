import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.prism.Image;

public class imageUtils {

	/**
	 * @param pressText 要添加的水印文字
	 * @param srcImageFile 图片源文件
	 * @param destImageFile 图片目标文件
	 * @param fontName 水印的字体名称
	 * @param fontStyle 水印的字体样式
	 * @param color 水印的字体颜色
	 * @param fontSize 水印的字体大小
	 * @param x 修正值
	 * @param y 修正值
	 * @param alpha 透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
	 * @throws IOException 
	 */
	public final static void pressText(String pressText, 
			String srcImageFile, String destImageFile, String fontName, int fontStyle,
			Color color, int fontSize,int x,int y,float alpha) throws IOException{
		
		File img = new File(srcImageFile);
		BufferedImage src = ImageIO.read(img);
		int width = src.getWidth();
		int height = src.getHeight();
		BufferedImage b = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = b.createGraphics();
		g.drawImage(src, 0, 0, width, height, null);
		
		g.setColor(color);
		g.setFont(new Font(fontName, fontStyle, fontSize));
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                alpha));
		
		g.drawString(pressText, (width - (pressText.length()) * fontSize)
                / 2 + x, (height - fontSize) / 2 + y);
		
		g.dispose();
		ImageIO.write((BufferedImage) b, "JPEG", new File(destImageFile));
		
	} 

}
