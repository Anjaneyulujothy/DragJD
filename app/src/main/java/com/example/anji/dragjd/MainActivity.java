package com.example.anji.dragjd;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.Toast;
        import android.view.DragEvent;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    float dX;
    float dY;
    int lastAction;
  ImageButton  d8;
    ImageButton  d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View dragView = findViewById(R.id.draggable_view);

        final View d1 = findViewById(R.id.d1);
        final View d2 = findViewById(R.id.d2);
        final View d3 = findViewById(R.id.d3);
    d= (ImageButton) findViewById(R.id.d3);
     d8= (ImageButton) findViewById(R.id.d);

        dragView.setOnTouchListener(MainActivity.this);
        d1.setOnTouchListener(MainActivity.this);
        d2.setOnTouchListener(MainActivity.this);
        d3.setOnTouchListener(MainActivity.this);
        d.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

           d8.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Why did you do that? That REALLY hurts!!!", Toast.LENGTH_LONG).show();


                return true;
            }
        });
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                dX = view.getX() - event.getRawX();
                dY = view.getY() - event.getRawY();
                lastAction = MotionEvent.ACTION_DOWN;
                break;

            case MotionEvent.ACTION_MOVE:
                view.setY(event.getRawY() + dY);
                view.setX(event.getRawX() + dX);
                lastAction = MotionEvent.ACTION_MOVE;



                break;
            case DragEvent.ACTION_DROP:

d.setVisibility(View.INVISIBLE);
d8.setVisibility(View.INVISIBLE);
                break;

            case MotionEvent.ACTION_UP:
                if (lastAction == MotionEvent.ACTION_DOWN)
                    Toast.makeText(MainActivity.this, "Clicked!", Toast.LENGTH_SHORT).show();
                d8.setVisibility(View.VISIBLE);
                break;

            default:
                return false;
        }
        return true;
    }
}