import com.sun.jna.LastErrorException;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCall;
import com.sun.jna.win32.StdCallLibrary;

public class Main
{
    public interface BASS extends StdCallLibrary
    {
        boolean BASS_Start() throws LastErrorException;

        boolean BASS_Init(int device, int freq, int flags, Pointer win, Pointer dsguid) throws LastErrorException;
        boolean BASS_Stop() throws LastErrorException; //Stoping BASS :>
    }
    public static final BASS INSTANCE = Platform.isWindows() ? Native.load("bass.dll", BASS.class) : null;

    public static void Bass_Start()
    {
        INSTANCE.BASS_Init(-1, 48000, 0, Pointer.NULL, Pointer.NULL);
        if(INSTANCE.BASS_Start()){
            System.out.printf("BASS IS STARTED!!!");
        }
        else{
            System.out.printf("Bass Is Not Founded or BASS Is Not Initializated");
        }
    }
    public static void main(String[] args) {
        Bass_Start();
    }
}
