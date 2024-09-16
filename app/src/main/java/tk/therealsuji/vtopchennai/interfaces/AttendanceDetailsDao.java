package tk.therealsuji.vtopchennai.interfaces;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import tk.therealsuji.vtopchennai.models.AttendanceDetails;

@Dao
public interface AttendanceDetailsDao {

    @Insert
    Completable insert(List<AttendanceDetails> attendanceDetails);

    @Insert
    Completable insertSingle(AttendanceDetails attendanceDetails);

    @Update
    Completable update(AttendanceDetails attendanceDetails);

    @Query("DELETE FROM attendance_details")
    Completable deleteAll();

    @Query("DELETE FROM attendance_details WHERE course_id = :courseId")
    Completable deleteByCourseId(int courseId);

    @Query("SELECT * FROM attendance_details")
    Single<List<AttendanceDetails>> getAllAttendanceDetails();

    @Query("SELECT * FROM attendance_details WHERE course_id = :courseId")
    Single<List<AttendanceDetails>> getAttendanceDetailsByCourseId(int courseId);

    @Query("SELECT COUNT(*) FROM attendance_details WHERE course_id = :courseId")
    Single<Integer> getAttendanceCountByCourseId(int courseId);

    @Query("UPDATE attendance_details SET attended = :attended, total = :total, percentage = :percentage WHERE id = :id")
    Completable updateAttendance(int id, int attended, int total, int percentage);
}
