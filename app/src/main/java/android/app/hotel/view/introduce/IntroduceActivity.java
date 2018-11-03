package android.app.hotel.view.introduce;

import android.app.hotel.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class IntroduceActivity extends AppCompatActivity {

    Toolbar toolbar;

    TextView tieuDe = null;
    TextView noidung = null;

    String mtieude = "Hotel Manager";

    String mnoidung = "Đến với Đà Nẵng – thành phố du lịch với vô số danh lam thắng cảnh đẹp, khu vui chơi sôi động, ẩm thực đặc sắc, con người thân thiện, AVA Hotel & Apartment sẽ là sự lựa chọn lý tưởng để đồng hành cũng bạn trong suốt chuyến đi khám phá vùng đất này. Với thiết kế sang trọng Âu – Á kết hợp, nội thất cao cấp 5 sao hiện đại mang đến sự gần gũi, ấm cúng, AVA Hotel & Apartment mong muốn cung cấp cho các bạn một căn hộ đầy đủ tiện nghi cũng như các tiện ích đi kèm với mức giá hợp lý nhất. Khách sạn và căn hộ Ava là một trong những khách sạn gần bãi biển Mỹ Khê Đà Nẵng và cũng là khách sạn Đà Nẵng gần biển giá rẻ nhất hiện nay.\n" +
            "\n" +
            "Chỉ mất 1 phút đi bộ, bạn có thể đặt chân lên bãi biển Mỹ Khê – một trong 6 bãi biển đẹp nhất hành tinh được tạp chí Forbes bình chọn với cát trắng, nắng vàng và biển xanh.\n" +
            "\nNằm trong khu vực trung tâm du lịch, bạn có thể dễ dàng di chuyển đến các địa danh nổi tiếng như Cầu Rồng, Cầu khóa tình yêu, Công viên Châu Á, bán đảo Sơn Trà, Cù Lao Chàm, Ngũ Hành Sơn, Hội An,…Ngay cả khi đi bộ bạn vẫn có thể di chuyển đến các nhà hàng, siêu thị mini. Đây là khu vực an ninh tốt, là khu phố có nhiều người nước ngoài thường xuyên cư trú và du lịch.\n" +
            "\nVới quy mô 8 tầng và 10 phòng, chúng tôi mong muốn mang đến một không gian đủ rộng rãi nhưng vẫn ấm cúng, thân thiện và hơn cả là đảm bảo sự riêng tư cho quý khách trong thời gian lưu trú tại AVA Hotel & Apartment.\n" +
            "\nTrang thiết bị hiện đại, thiết kế theo phong cách tinh tế, kết hợp Âu – Á đem đến một không gian sang trọng và nội thất tiện nghi. Căn hộ những trang bị đầy đủ các thiết bị như một gia đình với: giường đệm êm ái, bếp hồng ngoại, máy hút mùi, tủ lạnh, đồ dùng bếp, điều hòa, tivi, phòng tắm nội thất cao cấp, bồn tắm.\n" +
            "\nNgoài các trang thiết bị hiện đại trong phòng, chúng tôi còn cung cấp các dịch vụ FREE: dọn phòng 2 lần/ tuần, máy giặt sấy, wifi, truyền hình cáp. Bên cạnh đó, chúng tôi còn có thể hỗ trợ quý khách đặt các tour du lịch trong ngày như: tour Hội An, tour Bà Nà Hill, tour Cù Lao Chàm,…\n" +
            "\nDù bạn đang định đi du lịch, nghỉ dưỡng hay công tác. Dù bạn ở ngắn ngày hay cư trú dài ngày. Dù bạn đi một mình, đi cặp đôi hay đi với đại gia đình. Chúng tôi vẫn luôn có những lựa chọn phù hợp với bạn và khiến cho chuyến đi của bạn trở nên hoàn hảo.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Giới thiệu");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tieuDe = (TextView)findViewById(R.id.txtTieuDe);
        noidung = (TextView)findViewById(R.id.txtNoiDung);

        tieuDe.setText(mtieude);

        noidung.setText(mnoidung);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home)
        {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
