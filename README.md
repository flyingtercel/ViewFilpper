# ViewFilpper
实现文本上下轮播
```
/**
 * ViewFilpper实现TextView广告上滚的效果
 * 可与ViewPager对比
 * */

public class MainActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper = (ViewFlipper) findViewById(R.id.view_filpper);

        for(int i = 0; i < 10; i++) {
            TextView tv = new TextView(this);
            tv.setId(i);
            tv.setText("滚动广告效果" + i);
            //. addView的参数是View，因此可以添加布局
            //. View view = LayoutInflater.from(this).inflate(R.layout.activity_main, null);
            viewFlipper.addView(tv);
        }
        //. 设置动画切换的时间间隔
        viewFlipper.setFlipInterval(2000);
        //. 设置进入的动画
        viewFlipper.setInAnimation(this, R.anim.roll_in);
        //. 设置退出的动画
        viewFlipper.setOutAnimation(this, R.anim.roll_out);
        //. 启动动画，开始循环；停止循环：stopFlipping
        viewFlipper.startFlipping();
        //. 设置监听
        viewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //. 测试单个控件 获取当前控件的id --> succeed
                int id = viewFlipper.getCurrentView().getId();
                Log.d("execute", id + "");

                //. 测试以布局View为单位的 -->succeed
                //. View view = viewFlipper.getCurrentView();
                //. TextView textView = (TextView) view.findViewById(R.id.tv_num);
                //. textView.setText("完全尅");
            }
        });
        //. 循环状态
        boolean state = viewFlipper.isFlipping();
    }
}
```
#### 滚入跟滚进的布局：
###### （1）roll_in.xml
```

<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <translate android:fromYDelta="100%p" android:toYDelta="0" android:duration="500"/>
    <alpha android:fromAlpha="0.0" android:toAlpha="1.0" android:duration="500" />
</set>
```

###### （2）roll_out.xml
```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <translate android:fromYDelta="0" android:toYDelta="-100%p" android:duration="500"/>
    <alpha android:fromAlpha="1.0" android:toAlpha="0.0" android:duration="500" />
</set>
```
