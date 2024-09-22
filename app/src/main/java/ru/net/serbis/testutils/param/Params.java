package ru.net.serbis.testutils.param;

import android.graphics.*;
import java.util.*;
import ru.net.serbis.testutils.*;
import ru.net.serbis.utils.*;
import ru.net.serbis.utils.param.*;

import ru.net.serbis.testutils.R;

public interface Params
{
    String APP = "SBUtils";
    Param TEXT = new TextViewParam(R.string.text, "text test value");
    Param EDIT_TEXT = new EditTextParam(R.string.edit_text, "edit test value");
    Param CHECK = new BooleanParam(R.string.check, true);
    String[] LIST_VALUES = new String[]{
        "value 1",
        "value 2",
        "value 3"
    };
    Param LIST = new ListParam(R.string.list, LIST_VALUES[0], LIST_VALUES);
    Param EDIT_NUM = new EditNumberParam(R.string.edit_num, 123);
    Param SEEK = new SeekBarParam(R.string.seek, 0, 100, 33, true);
    Param VIEW_DATE_TIME = new DateTimeViewParam(R.string.view_date_time, new Date());
    Param EDIT_DATE = new EditDateParam(R.string.edit_date, new Date());
    Param COLOR = new ColorParam(R.string.color, Color.GRAY);
    Param FILE = new FileParam(R.string.file, IOTool.get().getDownloadPath("test.json"), false, true, "json");
    Param DIR = new FileParam(R.string.dir, IOTool.get().getDownloadPath(), true, false, null);
    Param FILE_OR_DIR = new FileParam(R.string.file_or_dir, IOTool.get().getDownloadPath(), false, false, null);
    Param FILES = new FilesParam(R.string.files, false, true);
    Param STRINGS = new StringsParam(R.string.strings);

    Param[] PARAMS = new Param[]{
        TEXT,
        EDIT_TEXT,
        CHECK,
        LIST,
        EDIT_NUM,
        SEEK,
        VIEW_DATE_TIME,
        EDIT_DATE,
        COLOR,
        FILE,
        DIR,
        FILE_OR_DIR,
        FILES,
        STRINGS
    };
}
