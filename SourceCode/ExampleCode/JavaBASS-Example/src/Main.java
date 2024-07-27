import com.sun.jna.LastErrorException;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;

import java.nio.charset.StandardCharsets;

public class Main
{
    public interface BASS extends StdCallLibrary
    {
        boolean BASS_Start() throws LastErrorException;

        boolean BASS_Init(int device, int freq, int flags, Pointer win, Pointer dsguid) throws LastErrorException;
        boolean BASS_Stop() throws LastErrorException; //Stoping BASS :>

        long BASS_StreamCreateFile(int mem, String filename, int offset, int length, int flags);

        void BASS_ChannelPlay(long handle, boolean restart);
    }
    public static final BASS INSTANCE = Platform.isWindows() ? Native.load("bass.dll", BASS.class) : null;

    public static String UTF16ToUTF8(String new_string){
        String s = new_string;
        String convertedInUTF8 = new String(s.getBytes(), StandardCharsets.UTF_8);
        return convertedInUTF8;
    }
    public static void Bass_Start()
    {
        INSTANCE.BASS_Init(-1, 48000, 0, Pointer.NULL, Pointer.NULL);
        if(INSTANCE.BASS_Start()){
            System.out.printf("BASS IS STARTED!!!");
        }
        else{
            System.out.printf("BASS Module is not Founded... Make Sure what bass.dll is in YOU'RE CURRENT FOLDER!!!");
        }
        String KanaBoonSpiral = UTF16ToUTF8("TheMisfitOfDemonKing2PART2_BURNOUTSYNDROME.mp3");
        long bass_stream = INSTANCE.BASS_StreamCreateFile(0, KanaBoonSpiral, 0, 0, 0x4);
        INSTANCE.BASS_ChannelPlay(bass_stream, false);
    }
    public static void main(String[] args) throws InterruptedException {
        Bass_Start();
        while (true)
        {
            Thread.sleep(8);
        }
    }
}
