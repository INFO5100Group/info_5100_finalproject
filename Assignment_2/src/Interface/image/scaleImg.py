from PIL import Image
import os

index = 0;

def scale_img(file_name):
    image = Image.open(file_name)
    new_image = image.resize((50, 50))
    outname = file_name.split('.')[0] + "50" + ".png"
    new_image.save(outname)

if __name__ == '__main__':
    scale_img('Assignment_2.png')

    