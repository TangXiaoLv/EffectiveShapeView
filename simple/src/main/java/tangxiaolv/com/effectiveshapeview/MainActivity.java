
package tangxiaolv.com.effectiveshapeview;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import tangxiaolv.com.library.EffectiveShapeView;
import tangxiaolv.com.library.EffectiveShapeView.Shape;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    private int mDirections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText sides = (EditText) findViewById(R.id.sides);
        final EditText border = (EditText) findViewById(R.id.border);
        final EditText padding = (EditText) findViewById(R.id.padding);
        final EffectiveShapeView shape = (EffectiveShapeView) findViewById(R.id.shape);
        final Button change = (Button) findViewById(R.id.change);
        RadioGroup decorations = (RadioGroup) findViewById(R.id.decorations);

        assert change != null;
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert sides != null;
                String strSide = sides.getText().toString();
                strSide = TextUtils.isEmpty(strSide) ? "6" : strSide;
                int intSides = Integer.parseInt(strSide);

                assert border != null;
                String strBorder = border.getText().toString();
                strBorder = TextUtils.isEmpty(strBorder) ? "0" : strBorder;
                int intBorder = Integer.parseInt(strBorder);

                assert padding != null;
                String strPadding = padding.getText().toString();
                strPadding = TextUtils.isEmpty(strPadding) ? "0" : strPadding;
                int intPadding = Integer.parseInt(strPadding);

                assert shape != null;
                shape.changeShapeType(Shape.POLYGON, intSides);
                shape.setBorderColor(Color.RED);
                shape.setBorderWidth(intBorder);

                if (mDirections != 0) {
                    Drawable decorations = getResources().getDrawable(R.drawable.triangle);
                    shape.setDecorations(mDirections, intPadding, decorations);
                } else {
                    shape.setDecorations(mDirections, intPadding, null);
                }
            }
        });

        assert decorations != null;
        decorations.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.a:
                        mDirections = 0;
                        break;
                    case R.id.b:
                        mDirections = 1;
                        break;
                    case R.id.c:
                        mDirections = 2;
                        break;
                    case R.id.d:
                        mDirections = 3;
                        break;
                    case R.id.e:
                        mDirections = 4;
                        break;

                }
            }
        });

        fillList();
    }

    private void fillList() {
        ListView list = (ListView) findViewById(R.id.list);
        assert list != null;
        list.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 100;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = View.inflate(parent.getContext(), R.layout.item_list, null);
                }
                EffectiveShapeView shapeView = (EffectiveShapeView) convertView
                        .findViewById(R.id.shape);
                switch (position % 9) {
                    case 0:
                        shapeView.changeShapeType(Shape.RECTANGLE);
                        break;
                    case 1:
                        shapeView.changeShapeType(Shape.ROUND_RECTANGLE);
                        shapeView.setDegreeForRoundRectangle(32, 32);
                        break;
                    case 2:
                        shapeView.changeShapeType(Shape.CIRCLE);
                        break;
                    case 3:
                        shapeView.changeShapeType(Shape.SQUARE);
                        break;
                    case 4:
                        shapeView.changeShapeType(Shape.POLYGON, 3);
                        break;
                    case 5:
                        shapeView.changeShapeType(Shape.POLYGON, 4);
                        break;
                    case 6:
                        shapeView.changeShapeType(Shape.POLYGON, 5);
                        break;
                    case 7:
                        shapeView.changeShapeType(Shape.POLYGON, 6);
                        break;
                    case 8:
                        shapeView.changeShapeType(Shape.POLYGON, 7);
                        break;
                }

                if (position < 10) {
                    shapeView.setBorderWidth(0);
                } else if (position < 20) {
                    shapeView.setBorderWidth(2);
                } else if (position < 30) {
                    shapeView.setBorderWidth(4);
                } else if (position < 40) {
                    shapeView.setBorderWidth(6);
                } else if (position < 50) {
                    shapeView.setBorderWidth(8);
                } else if (position < 60) {
                    shapeView.setBorderWidth(10);
                } else if (position < 70) {
                    shapeView.setBorderWidth(12);
                } else if (position < 80) {
                    shapeView.setBorderWidth(14);
                } else if (position < 70) {
                    shapeView.setBorderWidth(16);
                } else if (position < 100) {
                    shapeView.setBorderWidth(18);
                }
                return convertView;
            }
        });
    }
}
