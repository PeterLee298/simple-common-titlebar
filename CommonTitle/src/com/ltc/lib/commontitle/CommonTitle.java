
package com.ltc.lib.commontitle;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ltc.commontitle.R;

public class CommonTitle extends RelativeLayout {

    private View rootView;
    private ImageView backImageView;
    private ImageView rightImageView;
    private ImageView rightImageView2;
    private TextView titleTextView;

    int bgColor;
    int backBtnSrc;
    int rightBtnSrc;
    int rightBtn2Src;
    int titleText;
    int titleColor;

    private TitleClickListener titleClickListener;

    public CommonTitle(Context context) {
        this(context, null);
    }
    
    public CommonTitle(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.common_title, this, true);
        rootView = findViewById(R.id.common_title_root);
        backImageView = (ImageView) findViewById(R.id.common_title_left_img);
        rightImageView = (ImageView) findViewById(R.id.common_title_right_img);
        rightImageView2 = (ImageView) findViewById(R.id.common_title_right_img2);
        titleTextView = (TextView) findViewById(R.id.common_title_title_text);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.common_title);
        bgColor = array.getResourceId(R.styleable.common_title_bgColor, -1);
        backBtnSrc = array.getResourceId(R.styleable.common_title_backBtnSrc, -1);
        rightBtnSrc = array.getResourceId(R.styleable.common_title_rightBtnSrc, -1);
        rightBtn2Src = array.getResourceId(R.styleable.common_title_rightBtn2Src, -1);
        titleText = array.getResourceId(R.styleable.common_title_titleText, -1);
        titleColor = array.getResourceId(R.styleable.common_title_titleColor, -1);

        if (bgColor != -1) {
            rootView.setBackgroundResource(bgColor);
        } else {
            rootView.setBackgroundResource(android.R.color.darker_gray);
        }

        if (backBtnSrc != -1) {
            backImageView.setImageResource(backBtnSrc);
            backImageView.setVisibility(View.VISIBLE);
            backImageView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (titleClickListener != null) {
                        titleClickListener.onLeftClicked(CommonTitle.this, v);
                    }
                }
            });
        }

        if (rightBtnSrc != -1) {
            rightImageView.setImageResource(rightBtnSrc);
            rightImageView.setVisibility(View.VISIBLE);
            rightImageView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (titleClickListener != null) {
                        titleClickListener.onRightClicked(CommonTitle.this, v);
                    }
                }
            });
        }

        if (rightBtn2Src != -1) {
            rightImageView2.setImageResource(rightBtn2Src);
            rightImageView2.setVisibility(View.VISIBLE);
            rightImageView2.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (titleClickListener != null) {
                        titleClickListener.onRight2Clicked(CommonTitle.this, v);
                    }
                }
            });
        }

        if (titleText != -1) {
            titleTextView.setText(titleText);
            titleTextView.setVisibility(View.VISIBLE);
        }

        if (titleColor != -1) {
            titleTextView.setTextColor(getResources().getColor(titleColor));
        }

        array.recycle();
    }

    public void setOnTitleClickListener(TitleClickListener clickListener) {
        this.titleClickListener = clickListener;
    }

    /**
     * set title text
     * 
     * @param resId in string.xml
     */
    public void setTitleText(int resId) {
        titleTextView.setVisibility(View.VISIBLE);
        titleTextView.setText(resId);
    }

    /**
     * set title text
     * 
     * @param text
     */
    public void setTitleText(CharSequence text) {
        titleTextView.setVisibility(View.VISIBLE);
        titleTextView.setText(text);
    }
    
    /**
     * set title text color
     * @param resId
     */
    public void setTitleTextColor(int resId) {
        titleTextView.setTextColor(getResources().getColor(resId));
    }
    
    /**
     * 
     * @param clickable
     */
    public void setnRightClickable(boolean clickable) {
        if (rightBtnSrc != -1) {
            rightImageView.setClickable(clickable);
        }
    }

    /**
     * 
     * @param visibility
     */
    public void setRightVisibility(int visibility) {
        if (rightBtnSrc != -1) {
            rightImageView.setVisibility(visibility);
        }
    }

    /**
     * 
     * @param visibility
     */
    public void setRight2Visibility(int visibility) {
        if (rightBtn2Src != -1) {
            rightImageView2.setVisibility(visibility);
        }
    }

    public void setRightImageViewBackgroundResource(int resid) {
        rightImageView.setBackgroundResource(resid);
    }

    public interface TitleClickListener {
        public void onLeftClicked(View parent, View v);

        public void onRightClicked(View parent, View v);

        public void onRight2Clicked(View parent, View v);
    }
}
