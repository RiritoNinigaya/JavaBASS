import zipfile as zip
import os

def Main():
    print("My Path(JavaBASS-Release.zip): " + os.curdir)
    with zip.ZipFile(file="JavaBASS-Release.zip") as zip_file:
        zip_file.extractall(path="{}".format(os.curdir))
        print("Extracted!!!")
    os._exit(403)

if __name__ == "__main__":
    Main()