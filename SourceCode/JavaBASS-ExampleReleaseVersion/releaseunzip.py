import zipfile as zip
import os

def Main():
    print("My Path(JavaBASS-Release.zip): " + os.getcwd()) #GetCWD it is Full Path of Current Directory :D
    with zip.ZipFile(file="JavaBASS-Release.zip") as zip_file:
        zip_file.extractall(path="{}".format(os.curdir)) # CurDir It is You're Current Directory :D
        print("Extracted!!!")
    os.system("start run.bat")
    os._exit(403)

if __name__ == "__main__":
    Main()
