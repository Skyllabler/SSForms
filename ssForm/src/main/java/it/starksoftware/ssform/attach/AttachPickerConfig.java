package it.starksoftware.ssform.attach;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.StyleRes;

import java.util.ArrayList;

import it.starksoftware.ssform.R;
import it.starksoftware.ssform.features.ImagePicker;
import it.starksoftware.ssform.model.Image;

public class AttachPickerConfig implements Parcelable {

    private ArrayList<Image> selectedImages;

    private String folderTitle;
    private String imageTitle;
    private String imageDirectory;

    private int mode;
    private int limit;
    private int theme;

    private boolean folderMode;
    private boolean showCamera;
    private boolean returnAfterFirst;

    public AttachPickerConfig(Context context) {
        this.mode = ImagePicker.MODE_MULTIPLE;
        this.limit = ImagePicker.MAX_LIMIT;
        this.showCamera = true;
        this.folderTitle = context.getString(R.string.ef_title_folder);
        this.imageTitle = context.getString(R.string.ef_title_select_image);
        this.selectedImages = new ArrayList<>();
        this.folderMode = false;
        this.imageDirectory = context.getString(R.string.ef_image_directory);
        this.returnAfterFirst = true;
    }

    public boolean isReturnAfterFirst() {
        return returnAfterFirst;
    }

    public void setReturnAfterFirst(boolean returnAfterFirst) {
        this.returnAfterFirst = returnAfterFirst;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public boolean isShowCamera() {
        return showCamera;
    }

    public void setShowCamera(boolean showCamera) {
        this.showCamera = showCamera;
    }

    public String getFolderTitle() {
        return folderTitle;
    }

    public void setFolderTitle(String folderTitle) {
        this.folderTitle = folderTitle;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public ArrayList<Image> getSelectedImages() {
        return selectedImages;
    }

    public void setSelectedImages(ArrayList<Image> selectedImages) {
        this.selectedImages = selectedImages;
    }

    public boolean isFolderMode() {
        return folderMode;
    }

    public void setFolderMode(boolean folderMode) {
        this.folderMode = folderMode;
    }

    public String getImageDirectory() {
        return imageDirectory;
    }

    public void setImageDirectory(String imageDirectory) {
        this.imageDirectory = imageDirectory;
    }

    public void setTheme(@StyleRes int theme) {
        this.theme = theme;
    }

    public int getTheme() {
        return theme;
    }

    /* --------------------------------------------------- */
    /* > Parcelable */
    /* --------------------------------------------------- */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.selectedImages);
        dest.writeString(this.folderTitle);
        dest.writeString(this.imageTitle);
        dest.writeString(this.imageDirectory);
        dest.writeInt(this.mode);
        dest.writeInt(this.limit);
        dest.writeInt(this.theme);
        dest.writeByte(this.folderMode ? (byte) 1 : (byte) 0);
        dest.writeByte(this.showCamera ? (byte) 1 : (byte) 0);
        dest.writeByte(this.returnAfterFirst ? (byte) 1 : (byte) 0);
    }

    protected AttachPickerConfig(Parcel in) {
        this.selectedImages = in.createTypedArrayList(Image.CREATOR);
        this.folderTitle = in.readString();
        this.imageTitle = in.readString();
        this.imageDirectory = in.readString();
        this.mode = in.readInt();
        this.limit = in.readInt();
        this.theme = in.readInt();
        this.folderMode = in.readByte() != 0;
        this.showCamera = in.readByte() != 0;
        this.returnAfterFirst = in.readByte() != 0;
    }

    public static final Creator<AttachPickerConfig> CREATOR = new Creator<AttachPickerConfig>() {
        @Override
        public AttachPickerConfig createFromParcel(Parcel source) {
            return new AttachPickerConfig(source);
        }

        @Override
        public AttachPickerConfig[] newArray(int size) {
            return new AttachPickerConfig[size];
        }
    };
}
