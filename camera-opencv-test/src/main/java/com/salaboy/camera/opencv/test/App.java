package com.salaboy.camera.opencv.test;

import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core;
import static com.googlecode.javacv.cpp.opencv_core.IPL_DEPTH_8U;
import static com.googlecode.javacv.cpp.opencv_core.cvClearMemStorage;
import static com.googlecode.javacv.cpp.opencv_core.cvLoad;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2GRAY;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_INTER_AREA;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvResize;
import com.googlecode.javacv.cpp.opencv_objdetect;
import static com.googlecode.javacv.cpp.opencv_objdetect.CV_HAAR_DO_CANNY_PRUNING;
import static com.googlecode.javacv.cpp.opencv_objdetect.cvHaarDetectObjects;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {

    private opencv_objdetect.CvHaarClassifierCascade classifier = null;
    private opencv_core.CvMemStorage storage = null;
    private opencv_core.IplImage grayImage = null, smallImage = null;
    private opencv_core.CvSeq faces = null;
    private boolean stop = false;
    private Exception exception = null;

    public static void main(String[] args) throws Exception {

        new App();

    }

    public App() throws FrameGrabber.Exception {
        init();

        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber("");


        grabber.start();


        opencv_core.IplImage frame = grabber.grab();


        while ((frame = grabber.grab()) != null) {
            grayImage = opencv_core.IplImage.create(frame.width(), frame.height(), IPL_DEPTH_8U, 1);
            smallImage = opencv_core.IplImage.create(frame.width() / 4, frame.height() / 4, IPL_DEPTH_8U, 1);
            if (faces == null) {
                cvClearMemStorage(storage);
                cvCvtColor(frame, grayImage, CV_BGR2GRAY);
                cvResize(grayImage, smallImage, CV_INTER_AREA);
                faces = cvHaarDetectObjects(smallImage, classifier, storage, 1.1, 3, CV_HAAR_DO_CANNY_PRUNING);

            }
            
            paint(grabber, frame);

        }
        grabber.stop();
        System.exit(0);
    }

    public void init() {
        try {

            String classiferName = "/Users/salaboy/MyApps/OpenCV-2.4.3/data/haarcascades/haarcascade_frontalface_alt.xml";

            classifier = new opencv_objdetect.CvHaarClassifierCascade(cvLoad(classiferName));
            
            if (classifier.isNull()) {
                throw new IOException("Could not load the classifier file.");
            }

            storage = opencv_core.CvMemStorage.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public opencv_core.IplImage paint(OpenCVFrameGrabber grabber, opencv_core.IplImage image1) {
        if (faces != null) {
            int total = faces.total();
            System.out.println("Faces = " + total);
            faces = null;
        }


        return null;

    }
}
