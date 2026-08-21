package com.example.mycounter;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class EmotionLogActivity extends AppCompatActivity {

    private RadioGroup radioGroupEmotion;
    private EditText editTextDescription;
    private Button btnSave;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion_log);

        // 初始化控件
        radioGroupEmotion = findViewById(R.id.radio_group_emotion);
        editTextDescription = findViewById(R.id.et_description);
        btnSave = findViewById(R.id.btn_save);

        // 获取 SharedPreferences 实例
        sharedPreferences = getSharedPreferences("emotion_prefs", MODE_PRIVATE);

        // 设置默认选中项（开心）
        RadioButton rbHappy = findViewById(R.id.rb_happy);
        rbHappy.setChecked(true);

        // 设置保存按钮点击事件
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveEmotionRecord();
            }
        });
    }

    private void saveEmotionRecord() {
        // 获取选中的情绪类型
        int checkedId = radioGroupEmotion.getCheckedRadioButtonId();
        String emotionType = "happy"; // 默认值

        if (checkedId == R.id.rb_happy) {
            emotionType = "happy";
        } else if (checkedId == R.id.rb_sad) {
            emotionType = "sad";
        } else if (checkedId == R.id.rb_anxious) {
            emotionType = "anxious";
        } else if (checkedId == R.id.rb_calm) {
            emotionType = "calm";
        }

        // 获取描述文本
        String description = editTextDescription.getText().toString().trim();

        // 创建 JSON 对象
        JSONObject emotionJson = new JSONObject();
        try {
            emotionJson.put("type", emotionType);
            emotionJson.put("desc", description);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "保存失败：数据格式错误", Toast.LENGTH_SHORT).show();
            return;
        }

        // 保存到 SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("last_emotion", emotionJson.toString());
        editor.apply();

        // 显示成功提示
        Toast.makeText(this, getString(R.string.emotion_save_success), Toast.LENGTH_SHORT).show();
    }
}