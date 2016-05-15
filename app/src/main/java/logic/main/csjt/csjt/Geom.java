package logic.main.csjt.csjt;

import android.opengl.GLES20;
import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * Created by tom on 09.04.16.
 */

public class Geom {
    private static final String TAG = "CSJT";
    float px , py ,pz;
    static int pages;
    static int verticesPerPage;
    float[] coords;
    private float[] geomColors;
    public static float[] selectedGeomColors;
    private FloatBuffer fbGeomColors;
    private FloatBuffer fbSelectedGeomColors;
    FloatBuffer vertics;

    public FloatBuffer getFbSelectedGeomColors() {
        return fbSelectedGeomColors;
    }

    public void setFbSelectedGeomColors(FloatBuffer fbSelectedGeomColors) {
        this.fbSelectedGeomColors = fbSelectedGeomColors;
    }

    public void setGeomColors(float[] geomColors) {
        this.geomColors = geomColors;
    }

    public void setFbGeomColors(FloatBuffer fbGeomColors) {
        this.fbGeomColors = fbGeomColors;
    }

    public FloatBuffer getFbGeomColors() {
        return this.fbGeomColors;
    }

    public float[] setInitColor(float r, float g, float b,float a) {

    float[] INIT_COLORS = new float[pages*verticesPerPage*4];

    for(int j = 0; j < pages;j++){
        for(int i = 0;i < verticesPerPage; i++){
            INIT_COLORS[(verticesPerPage*j*4 + i*4) + 0] = r;
        }
    }
    for(int j = 0; j < pages; j++){
        for(int i = 0;i < verticesPerPage; i++){
            INIT_COLORS[(verticesPerPage*j*4 + i*4) + 1] = g;
        }
    }
    for(int j = 0; j < pages; j++){
        for(int i = 0;i < verticesPerPage; i++){
            INIT_COLORS[(verticesPerPage*j*4 + i*4) + 2] = b;
        }
    }
    for(int j = 0; j < pages; j++){
        for(int i = 0;i < verticesPerPage; i++){
            INIT_COLORS[(verticesPerPage*j*4 + i*4) + 3] = a;
        }
    }
    return INIT_COLORS;
    }

    public float[] setSelectedGeomColors() {

        float[] S_COLORS = new float[pages*verticesPerPage*4];

        for(int j = 0; j < pages;j++){
            for(int i = 0;i < verticesPerPage; i++){
                S_COLORS[(verticesPerPage*j*4 + i*4) + 0] = 1.0f;
            }
        }
        for(int j = 0; j < pages; j++){
            for(int i = 0;i < verticesPerPage; i++){
                S_COLORS[(verticesPerPage*j*4 + i*4) + 1] = 1.0f;
            }
        }
        for(int j = 0; j < pages; j++){
            for(int i = 0;i < verticesPerPage; i++){
                S_COLORS[(verticesPerPage*j*4 + i*4) + 2] = 1.0f;
            }
        }
        for(int j = 0; j < pages; j++){
            for(int i = 0;i < verticesPerPage; i++){
                S_COLORS[(verticesPerPage*j*4 + i*4) + 3] = 1.0f;
            }
        }
        return S_COLORS;
    }

    public FloatBuffer colorFloatBuffer(){

        FloatBuffer lFloatBuffer;
        ByteBuffer bbColors = ByteBuffer.allocateDirect(this.geomColors.length * 4);
        bbColors.order(ByteOrder.nativeOrder());
        lFloatBuffer = bbColors.asFloatBuffer();
        lFloatBuffer.put(this.geomColors);
        lFloatBuffer.position(0);
        return lFloatBuffer;
    }
    public FloatBuffer setSelectedColorFloatBuffer(){

        FloatBuffer lFloatBuffer;
        ByteBuffer bbColors = ByteBuffer.allocateDirect(this.selectedGeomColors.length * 4);
        bbColors.order(ByteOrder.nativeOrder());
        lFloatBuffer = bbColors.asFloatBuffer();
        lFloatBuffer.put(this.selectedGeomColors);
        lFloatBuffer.position(0);
        return lFloatBuffer;
    }

    /**
     * Checks if we've had an error inside of OpenGL ES, and if so what that error is.
     *
     * @param label Label to report in case of error.
     */
    public static void checkGLError(String label) {
        int error;
        while ((error = GLES20.glGetError()) != GLES20.GL_NO_ERROR) {
            Log.e(TAG, label + ": glError " + error);
            throw new RuntimeException(label + ": glError " + error);
        }
    }
}