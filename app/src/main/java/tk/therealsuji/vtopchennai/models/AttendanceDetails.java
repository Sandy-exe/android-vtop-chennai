package tk.therealsuji.vtopchennai.models;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "attendance_details", foreignKeys = @ForeignKey(entity = Course.class, parentColumns = "id", childColumns = "course_id", onDelete = CASCADE))
public class AttendanceDetails {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "class_id")
    public Integer courseId;

    @ColumnInfo(name = "course_code")
    public String courseCode; // New field added

    @ColumnInfo(name = "attendance_date")
    public String attendanceDate;

    @ColumnInfo(name = "attendance_slot")
    public String attendanceSlot;

    @ColumnInfo(name = "day_and_timing")
    public String dayAndTiming;

    @ColumnInfo(name = "attendance_status")
    public String attendanceStatus;
}
