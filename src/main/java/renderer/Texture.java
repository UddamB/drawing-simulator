package renderer;
import org.lwjgl.BufferUtils;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.stb.STBImage.*;

public class Texture {
    private String filepath;
    private transient int textID;
    private int width, height;

    public Texture() {
        textID = -1;
        width = -1;
        height = -1;
    }
    public Texture(int width, int height){
        this.filepath = "Generated";

        //Generate texture on GPU
        textID = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, textID);

        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width,
                height, 0, GL_RGB, GL_UNSIGNED_BYTE, 0);
            }

    public void init(String filepath){
        this.filepath = filepath;

        //Generate texture on GPU
        textID = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, textID);

        //Set texture parameters
        //Repeat the image in both directions
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
        //When stretching the image, pixelate
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        //When shrinking an image, pixelate
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        IntBuffer width = BufferUtils.createIntBuffer(1);
        IntBuffer height = BufferUtils.createIntBuffer(1);
        IntBuffer channels = BufferUtils.createIntBuffer(1);
        //flipping images vertically
        stbi_set_flip_vertically_on_load(true);
        ByteBuffer image = stbi_load(filepath, width, height, channels, 0);

        if (image != null) {
            this.width = width.get(0);
            this.height = height.get(0);

            if (channels.get(0) == 3) {
                glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width.get(0),
                        height.get(0), 0, GL_RGB, GL_UNSIGNED_BYTE, image);
            }
            else if(channels.get(0) == 4){
                glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width.get(0),
                        height.get(0), 0, GL_RGBA, GL_UNSIGNED_BYTE, image);
            }
            else{
                assert false : "Error: (Texture) Unknown umber of channels '" + channels.get(0) + "'";
            }
        }
        else {
            assert false : "Error: (Texture) Could not load image '" + filepath + "'";
        }
        stbi_image_free(image);
    }

    public void bind(){
        glBindTexture(GL_TEXTURE_2D, textID);
    }
    public void unbind(){
        glBindTexture(GL_TEXTURE_2D, 0);
    }
    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public String getFilepath(){
        return this.filepath;
    }

    public int getId(){
        return textID;
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof Texture)) return false;
        Texture oTex = (Texture)o;
        return oTex.getWidth() == this.width && oTex.getHeight() ==
                this.height && oTex.getId() == this.textID &&
                oTex.getFilepath().equals(this.filepath);
    }
}