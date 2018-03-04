import face_recognition
import os
import io
from PIL import Image
from array import array
import glob
import numpy
import random
import collections
import base64
import sys

# This is a demo of running face recognition on live video from your webcam. It's a little more complicated than the
# other example, but it includes some basic performance tweaks to make things run a lot faster:
#   1. Process each video frame at 1/4 resolution (though still display it at full resolution)
#   2. Only detect faces in every other frame of video.

# PLEASE NOTE: This example requires OpenCV (the `cv2` library) to be installed only to read from your webcam.
# OpenCV is *not* required to use the face_recognition library. It's only required if you want to run this
# specific demo. If you have trouble installing it, try any of the other demos that don't require it instead.

# Get a reference to webcam #0 (the default one)


known_face_encodings = []

known_face_names = []

pattern = '*.jpg'

os.chdir('DB')
for filename in glob.glob("*.jpg"):
    tempImage = face_recognition.load_image_file(filename)
    tempEncode = face_recognition.face_encodings(tempImage) [0]
    known_face_encodings.append(tempEncode)
    known_face_names.append(str(filename).split('.')[0])

# Initialize some variables
face_locations = []
face_encodings = []
face_names = []


def face_rec(img_byte_array):

    rgb_small_frame = face_recognition.load_image_file(img_byte_array)
    # Find all the faces and face encodings in the current frame of video
    face_locations = face_recognition.face_locations(rgb_small_frame)
    face_encodings = face_recognition.face_encodings(rgb_small_frame, face_locations)

    face_names = []
    for face_encoding in face_encodings:
        # See if the face is a match for the known face(s)
        matches = face_recognition.compare_faces(known_face_encodings, face_encoding)
        name = "Unknown"

        # If a match was found in known_face_encodings, just use the first one.
        if True in matches:
            first_match_index = matches.index(True)
            fluid = known_face_names[first_match_index]

        face_names.append(fluid)

    return fluid


# def face_recog(path):
#     os.chdir('DB')
#     count = os.stat(path).st_size / 2
#     with open(path, "rb") as f:
#      return bytearray(f.read())
#
# bytes = readimage(path + extension)
# image = Image.open(io.BytesIO(bytes))
# image.save(savepath)


imageFile = open(sys.argv[1], "rb")
# f = imageFile.read()
# b = Image.open(io.BytesIO((f)))
# print b

#strImg = base64.b64encode(imageFile.read())

str = (face_rec(imageFile))

print (str)
