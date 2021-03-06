package logic.main.csjt.csjt;

/**
 * Created by Pygentrix on 20.05.2016.
 */

class Prism extends Geom{

    //SETTERS
    private float[] setPrismCoords(float px, float py, float pz, float width, float height){

        //TODO: Implement it correct, some rendering fuck ups. Still not correct

        /**
         * Experiment: I'll try to seperate the rectangular sides into two triangular sides and see what happens
         */

        return new float[]{
                // Top face
                px, py+height, pz,
                px+width, py+height, pz,
                px+(width/2), py+height, pz+(width/2),

                // Bottom face
                px, py, pz,
                px+width, py, pz,
                px+(width/2), py, (pz+width/2),

                // Back face
                px, py, pz,
                px+width, py, pz,
                px, py+height, pz,

                px+width, py+height, pz,
                px+width, py, pz,
                px, py+height, pz,


                // Left face
                px, py, pz,
                px+(width/2), py, pz+(width/2),
                px, py+height, pz,

                px+(width/2), py+height, pz+(width/2),
                px+(width/2), py, pz+(width/2),
                px, py+height, pz,


                // Right face
                px+width, py, pz,
                px+(width/2), py, pz+(width/2),
                px+width, py+height, pz,

                px+(width/2), py+height, pz+(width/2),
                px+(width/2), py, pz+(width/2),
                px+width, py+height, pz,

        };
    }


    private float[] setPrismNormals(float width, float height){

        return new float[]{
                //Top Face
                0.0f, height, 0.0f,
                0.0f, height, 0.0f,
                0.0f, height, 0.0f,


                // Bottom Face
                0.0f, -height, 0.0f,
                0.0f, -height, 0.0f,
                0.0f, -height, 0.0f,


                // Back face
                0.0f, 0.0f, -width,
                0.0f, 0.0f, -width,
                0.0f, 0.0f, -width,

                0.0f, 0.0f, -width,
                0.0f, 0.0f, -width,
                0.0f, 0.0f, -width,


                // Left Face (evtl - bie z achse)
                -width, 0.0f, width,
                -width, 0.0f, width,
                -width, 0.0f, width,

                -width, 0.0f, width,
                -width, 0.0f, width,
                -width, 0.0f, width,


                // Right Face
                width, 0.0f, width,
                width, 0.0f, width,
                width, 0.0f, width,

                width, 0.0f, width,
                width, 0.0f, width,
                width, 0.0f, width,

        };
    }


    //FUNCTIONS / METHODS

    //CONSTRUCTOR(S)
    Prism(Float x, Float y, Float z) {
        super(x,y,z);
        float r, g, b, a = 1.0f;
        //TODO FINSIH!

    }
    Prism(float x, float y, float z,float width,float height, float r, float g, float b, float a) {

        super(x,y,z);
        pages = 8;
        verticesPerPage = 3;
        vCount = 24;
        selectedGeomColors = setSelectedGeomColors();
        setFbSelectedGeomColors(setSelectedColorFloatBuffer());

        this.width = width;
        this.height = height;


        this.geomVertics = setPrismCoords(x, y, z, width, height);// Init Tetra Coords on first call
        this.geomNormals = setPrismNormals(width,height);
        setGeomColors(setInitColor(r, g, b, a)); // Init Tetra Colors on first call

        setFbGeomColors(colorFloatBuffer());
        this.fbGeomNormals = normalsFloatBuffer(); // NORMALS OF CUBE -> Normals
        this.fbGeomVertics = verticsFloatBuffer();  // COORDS OF CUBE -> Vertices

        this.updateModelPosition();



    }

}
