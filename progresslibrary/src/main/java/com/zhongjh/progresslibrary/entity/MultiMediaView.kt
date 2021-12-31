package com.zhongjh.progresslibrary.entity

import android.view.View
import com.zhongjh.common.entity.LocalFile
import com.zhongjh.common.entity.MultiMedia
import com.zhongjh.common.enums.MultimediaTypes
import com.zhongjh.progresslibrary.widget.MaskProgressView
import com.zhongjh.progresslibrary.widget.PlayProgressView

/**
 * 多媒体实体类,包含着view
 *
 * @author zhongjh
 * @date 2021/12/13
 */
class MultiMediaView : MultiMedia {

    companion object {

        private const val FULL_PERCENT = 100

    }

    /**
     * 绑定子view,包含其他所有控件（显示view,删除view）
     */
    lateinit var itemView: View

    /**
     * 绑定音频View
     */
    lateinit var playProgressView: PlayProgressView

    /**
     * 绑定子view: 用于显示图片、视频的view
     */
    lateinit var maskProgressView: MaskProgressView

    /**
     * 是否进行上传动作
     */
    var isUploading = false

    constructor()

    constructor(@MultimediaTypes multiMediaState: Int) {
        type = multiMediaState
    }

    constructor(localFile: LocalFile) {
        path = localFile.path
        uri = localFile.uri
        type = localFile.type
        mimeType = localFile.mimeType
        size = localFile.size
        duration = localFile.duration
        oldPath = localFile.oldPath
        oldUri = localFile.oldUri
        height = localFile.height
        width = localFile.width
    }

    /**
     * 给予进度，根据类型设置相应进度动作
     */
    fun setPercentage(percent: Int) {
        if (type == MultimediaTypes.PICTURE || type == MultimediaTypes.VIDEO) {
            this.maskProgressView.setPercentage(percent)
        } else if (type == MultimediaTypes.AUDIO) {
            // 隐藏显示音频的设置一系列动作
            playProgressView.mViewHolder.numberProgressBar.progress = percent
            if (percent == FULL_PERCENT) {
                playProgressView.audioUploadCompleted()
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        return super.anyEquals(other)
    }

    override fun hashCode(): Int {
        return super.anyHashCode()
    }
}