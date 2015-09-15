package cn.fundview.modules.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import cn.fundview.common.utils.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class ImgUtils {

	/**
	 * 	生产缩略图 
	 *  已经处理白边问题, 处理大图片时 需要设置内存大小 至少512m
	 *  
	 * @param oldFilePath 原图片全路径包括名称
	 * @param fileName 要生产文件名称
	 * @param newFilePath //新文件保存路径
	 * @param width 要生成宽
	 * @param height 要生成高
	 * @throws java.io.IOException
	 */
	public static void creatThumbnail(String oldFilePath,String fileName,String newFilePath,int width,int height) throws IOException{
		
		Image srcFile=null;//源文件
		FileOutputStream out=null;//要写入新文件
		ImageOutputStream ios=null;//新文件流
		
		try {			
			
			if(StringUtils.isBlank(oldFilePath))
			{
				return;
			}	       			
			File src=new File(oldFilePath);			
			
			/** 对服务器上的临时文件进行处理 */
			srcFile = ImageIO.read(src); 	
			
			// 做处理 加载完成后再获取图片
		    int sourceHeight = -1;
	        int sourceWidth = -1;
	        boolean flag = true;
	        while (flag) {
	        		sourceHeight = srcFile.getWidth(null); // 得到源图宽
	        		sourceWidth = srcFile.getHeight(null); // 得到源图长
	                //System.out.println("wideth:" + wideth + " height:" + height);
	                if (sourceWidth > 0 && sourceWidth > 0) { 
	                // 都大于0，表明图片已经加载完毕
	                // imageCanvas.setImage(srcImage);
	                    flag = false;
	                } else {
	                    try {
	                        Thread.sleep(10);
	                    } catch (Exception e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
			// 获取原图片 宽 和 高
			sourceWidth = srcFile.getWidth(null);
			sourceHeight = srcFile.getHeight(null);		
			
			// 技术比例 
			float f = (float)sourceWidth/width - (float)sourceHeight/height;
			/** 宽,高设定 */
			BufferedImage tag = null;
			Graphics g = null;		
			
			
			// 生产没有白边 等比例计算 宽 和 高
			int newWidth = 0;
			int newHeight = 0 ;
			if(f>0){				
				newHeight = (int) (sourceHeight/((float)sourceWidth/width));
				newWidth = width;
				
			}else{
				newWidth = (int) (sourceWidth/((float)sourceHeight/height));
				newHeight = height;	
			}
			
			tag = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);			
			g = tag.getGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, newWidth, newHeight);				
			g.drawImage(srcFile, 0, 0, newWidth, newHeight, null);			
	
			/** 压缩之后临时存放位置 */
			FileUtils.createDirectory(newFilePath);
			
			//新文件
			out = new FileOutputStream(newFilePath+fileName);		
			//--------------
			ImageWriter imgWrier;
			 ImageWriteParam imgWriteParams;
	
		        // 指定写图片的方式为 jpg
		        imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();
		        
		        imgWriteParams = new javax.imageio.plugins.jpeg.JPEGImageWriteParam(null);
		        
		        // 要使用压缩，必须指定压缩方式为MODE_EXPLICIT
		        imgWriteParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		        
		        // 这里指定压缩的程度，参数qality是取值0~1范围内，
		        imgWriteParams.setCompressionQuality(1f);
		        
		        imgWriteParams.setProgressiveMode(ImageWriteParam.MODE_DISABLED);
		        ColorModel colorModel = ColorModel.getRGBdefault();
		        // 指定压缩时使用的色彩模式
		        imgWriteParams.setDestinationType(new javax.imageio.ImageTypeSpecifier(colorModel, colorModel
		                .createCompatibleSampleModel(16, 16)));
		        
			imgWrier.reset();
	        // 必须先指定 out值，才能调用write方法, ImageOutputStream可以通过任何 OutputStream构造
		    ios=ImageIO.createImageOutputStream(out);
	        imgWrier.setOutput(ios);
	        
	        // 调用write方法，就可以向输入流写图片
	        imgWrier.write(null, new IIOImage(tag, null, null), imgWriteParams);
	        
	        imgWrier.dispose();//销毁
	        
		} catch (Exception e) {
			System.out.println("缩略图生产错误");
			e.printStackTrace();
		}finally{
			
	        if(ios!=null)
	        {
	        	ios.flush();
	        	ios.close();
	        }
	        if(out!=null)
	        {
	        	out.flush();
	        	out.close();
	        }
	        if(srcFile!=null)
	        {
	        	srcFile.flush();	        	
	        }        
			
		}
	}

	/**
     * 图片压缩
     * @param srcFilePath
     * @param newFilePath
     * @param quality 这里指定压缩的程度，参数qality是取值0~1范围内，
     * @return
     */
    public static boolean compressPic(String srcFilePath, String newFilePath, float quality)
    {
        File file = null;
        BufferedImage src = null;
        FileOutputStream out = null;
        
        ImageWriter imgWrier;
        ImageWriteParam imgWriteParams;

        // 指定写图片的方式为 jpg
        imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();
        
        imgWriteParams = new javax.imageio.plugins.jpeg.JPEGImageWriteParam(null);
        
        // 要使用压缩，必须指定压缩方式为MODE_EXPLICIT
        imgWriteParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        
        // 这里指定压缩的程度，参数qality是取值0~1范围内，
        imgWriteParams.setCompressionQuality(quality);
        
        imgWriteParams.setProgressiveMode(ImageWriteParam.MODE_DISABLED);
        ColorModel colorModel = ColorModel.getRGBdefault();
        // 指定压缩时使用的色彩模式
        imgWriteParams.setDestinationType(new javax.imageio.ImageTypeSpecifier(colorModel, colorModel
                .createCompatibleSampleModel(16, 16)));

        try
        {
            if(StringUtils.isBlank(srcFilePath))
            {
                return false;
            }
            else
            {
                file = new File(srcFilePath);
                src = ImageIO.read(file);
                out = new FileOutputStream(newFilePath);
                imgWrier.reset();
                // 必须先指定 out值，才能调用write方法, ImageOutputStream可以通过任何 OutputStream构造
                imgWrier.setOutput(ImageIO.createImageOutputStream(out));
                // 调用write方法，就可以向输入流写图片
                imgWrier.write(null, new IIOImage(src, null, null), imgWriteParams);
                out.flush();
                out.close();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
	
    /** 
     * 裁剪图片  页面展示宽和高最大是500
     * @param srcFile 源文件
     * @param outFile 输出文件
     * @param x 坐标
     * @param y 坐标
     * @param width 宽度 正数标识向正轴方向剪切 负数表示向负轴方向剪切
     * @param height 高度
     * @return 
     * @创建日期 2012-8-2 
     * @创建时间 下午02:05:03 
     * @描述 —— 裁剪图片 
     */  
    public static boolean cutPic(String srcFile, String outFile, int x, int y,  
            int width, int height) {  
        FileInputStream is = null;  
        ImageInputStream iis = null;  
        try {  
            // 如果源图片不存在  
            if (!new File(srcFile).exists()) {  
                return false;  
            }  
            
            
            // 读取图片文件  
            is = new FileInputStream(srcFile);  
  
            // 获取文件格式  
            String ext = srcFile.substring(srcFile.lastIndexOf(".") + 1);  
  
            // ImageReader声称能够解码指定格式  
            Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(ext);  
            ImageReader reader = it.next();  
            
            // 获取图片流  
            iis = ImageIO.createImageInputStream(is);  
  
            // 输入源中的图像将只按顺序读取  
            reader.setInput(iis, true);  

            // 描述如何对流进行解码  
            ImageReadParam param = reader.getDefaultReadParam();  
           
//            int oriWidth = reader.getWidth(-1);
//            int oriHeight = reader.getHeight(-1);
//            System.out.println(oriHeight);
//            System.out.println(oriWidth);
  
            // 图片裁剪区域  
            Rectangle rect =  null;
            
            if(width < 0) {
            	
            	x = x+width;
            }
            
            if(height < 0) {
            	
            	y = y + height;
            }
            
            BufferedImage sourceImg =ImageIO.read(new FileInputStream(srcFile));   
            System.out.println(sourceImg.getWidth());  
            System.out.println(sourceImg.getHeight());  
            double wradis = sourceImg.getWidth()/500.0;
            double hradis = sourceImg.getHeight()/500.0;
            double radis = wradis>hradis?wradis:hradis;
            
            if(radis <1){
            	
            	radis = 1;
            }
            rect =  new Rectangle((int)(x*radis), (int)(y*radis), (int)Math.abs(width*radis), (int)Math.abs(height*radis));
             
            // 提供一个 BufferedImage，将其用作解码像素数据的目标  
            param.setSourceRegion(rect);  
  
            // 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象  
            BufferedImage bi = reader.read(0, param);  
  
            // 保存新图片  
            File tempOutFile = new File(outFile);  
            if (!tempOutFile.exists()) {  
                tempOutFile.mkdirs();  
            }  
            ImageIO.write(bi, ext, new File(outFile));  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        } finally {  
            try {  
                if (is != null) {  
                    is.close();  
                }  
                if (iis != null) {  
                    iis.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
                return false;  
            }  
        }  
    }  
	public static void main(String[] args)
    {  
		try {

			//ImgUtils.creatThumbnail("D:/abc.jpg","abc-1.jpg","D:/",200,200);
			ImgUtils.cutPic("D:/abc.jpg","D:/abc-1.jpg",558,20,224,88);
			//ImgUtils.compressPic("D:/abc.jpg","D:/abc-2.jpg",0.7f);
			//ImgUtils.compressPic("D:/abc.jpg","D:/abc-3.jpg",0.3f);

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
		  

}
