package com.zhongjh.albumcamerarecorder.camera;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.otaliastudios.cameraview.CameraView;
import com.zhongjh.albumcamerarecorder.R;
import com.zhongjh.albumcamerarecorder.camera.entity.BitmapData;
import com.zhongjh.albumcamerarecorder.camera.widget.PhotoVideoLayout;
import com.zhongjh.albumcamerarecorder.widget.childclickable.ChildClickableRelativeLayout;

import it.sephiroth.android.library.imagezoom.ImageViewTouch;

/**
 * 继承于BaseCameraFragment
 *
 * @author zhongjh
 * @date 2022/8/12
 */
public class CameraFragment2 extends BaseCameraFragment {

    ViewHolder mViewHolder;

    @Override
    public int setContentView() {
        return R.layout.fragment_camera_zjh;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        mViewHolder = new ViewHolder(view);
    }

    @NonNull
    @Override
    public CameraView getCameraView() {
        return mViewHolder.cameraView;
    }

    @Override
    public RecyclerView getRecyclerViewPhoto() {
        return mViewHolder.rlPhoto;
    }

    @Nullable
    @Override
    public View[] getMultiplePhotoView() {
        return new View[]{mViewHolder.vLine1, mViewHolder.vLine2};
    }

    @Nullable
    @Override
    public PhotoVideoLayout getPhotoVideoLayout() {
        return mViewHolder.pvLayout;
    }

    @Nullable
    @Override
    public View[] getSinglePhotoView() {
        return new View[]{mViewHolder.rlEdit};
    }

    @Nullable
    @Override
    public View getCloseView() {
        return mViewHolder.imgClose;
    }

    @Nullable
    @Override
    public View getFlashView() {
        return mViewHolder.imgFlash;
    }

    @Nullable
    @Override
    public View getSwitchView() {
        return mViewHolder.imgSwitch;
    }

    @Override
    public void onDelete(BitmapData bitmapData, int position) {
        super.onDelete(bitmapData, position);
    }

    public static class ViewHolder {

        View rootView;
        ChildClickableRelativeLayout rlMain;
        ImageViewTouch imgPhoto;
        FrameLayout flShow;
        ImageView imgFlash;
        ImageView imgSwitch;
        PhotoVideoLayout pvLayout;
        RecyclerView rlPhoto;
        View vLine1;
        View vLine2;
        ImageView imgClose;
        CameraView cameraView;
        ConstraintLayout clMenu;
        RelativeLayout rlEdit;

        ViewHolder(View rootView) {
            this.rootView = rootView;
            this.rlMain = rootView.findViewById(R.id.rlMain);
            this.imgPhoto = rootView.findViewById(R.id.imgPhoto);
            this.flShow = rootView.findViewById(R.id.flShow);
            this.imgFlash = rootView.findViewById(R.id.imgFlash);
            this.imgSwitch = rootView.findViewById(R.id.imgSwitch);
            this.pvLayout = rootView.findViewById(R.id.pvLayout);
            this.rlPhoto = rootView.findViewById(R.id.rlPhoto);
            this.vLine1 = rootView.findViewById(R.id.vLine1);
            this.vLine2 = rootView.findViewById(R.id.vLine2);
            this.imgClose = rootView.findViewById(R.id.imgClose);
            this.cameraView = rootView.findViewById(R.id.cameraView);
            this.clMenu = rootView.findViewById(R.id.clMenu);
            this.rlEdit = rootView.findViewById(R.id.rlEdit);
        }

    }

}
