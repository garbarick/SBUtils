package ru.net.serbis.utils;

import android.os.*;
import java.io.*;
import org.json.*;

public class IOTool
{
    private static final IOTool instance = new IOTool();

    public static IOTool get()
    {
        return instance;
    }

    public void close(Object o)
    {
        try
        {
            if (o == null)
            {
                return;
            }
            if (o instanceof Closeable)
            {
                ((Closeable)o).close();
            }
            else if (o instanceof AutoCloseable)
            {
                ((AutoCloseable)o).close();
            }
        }
        catch (Exception e)
        {}
    }

    public void copy(InputStream is, OutputStream os, boolean closeIn, boolean closeOut, int bufferSize) throws Exception
    {
        try
        {
            byte[] buf = new byte[bufferSize];
            int len;
            while ((len = is.read(buf)) > 0)
            {
                os.write(buf, 0, len);
            }
        }
        finally
        {
            if (closeIn)
            {
                close(is);
            }
            if (closeOut)
            {
                close(os);
            }
        }
    }
    
    public void copyQuietly(InputStream is, OutputStream os, boolean closeIn, boolean closeOut, int bufferSize)
    {
        try
        {
            copy(is, os, closeIn, closeOut, bufferSize);
        }
        catch (Exception e)
        {
            Log.error(new IOTool(), e);
        }
    }

    public File getDownloadFile()
    {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    }

    public String getDownloadPath()
    {
        return getDownloadFile().getAbsolutePath();
    }

    public File getDownloadFile(String path)
    {
        return new File(getDownloadFile(), path);
    }
    
    public String getDownloadPath(String path)
    {
        return getDownloadFile(path).getAbsolutePath();
    }

    public String getExternalFile(String path)
    {
        File dir = Environment.getExternalStorageDirectory();
        return new File(dir, path).getAbsolutePath();
    }

    public void copy(JSONObject json, File file)
    {
        try
        {
            copy(json.toString(4), file);
        }
        catch (Exception e)
        {
            Log.error(this, e);
        }
    }

    public void copy(String content, File file)
    {
        OutputStreamWriter os = null;
        try
        {
            os = new OutputStreamWriter(new FileOutputStream(file));
            os.write(content);
        }
        catch (Exception e)
        {
            Log.error(this, e);
        }
        finally
        {
            close(os);
        }
    }

    public String readFile(File file, int bufferSize)
    {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try
        {
            InputStream is = new FileInputStream(file);
            copy(is, os, true, true, bufferSize);
        }
        catch (Exception e)
        {
            Log.error(this, e);
        }
        return os.toString();
    }

    public void copy(File source, File dest, int bufferSize)
    {
        try
        {
            dest.getParentFile().mkdirs();
            copy(new FileInputStream(source), new FileOutputStream(dest), true, true, bufferSize);
        }
        catch (Exception e)
        {
            Log.error(this, e);
        }
    }
}
