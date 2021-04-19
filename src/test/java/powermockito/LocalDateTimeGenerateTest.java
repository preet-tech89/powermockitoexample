package powermockito;

import static org.powermock.api.mockito.PowerMockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(LocalDateTimeGenerate.class)
public class LocalDateTimeGenerateTest {

  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  @Before
  public void setUp() {
    PowerMockito.mockStatic(LocalDateTime.class);
  }

  @Test
  public void testBefore4Pm() {
    final String before4Pm = "2021-04-19 15:30";
    LocalDateTime dateTime = LocalDateTime.parse(before4Pm, formatter);
    when(LocalDateTime.now()).thenReturn(dateTime);
    final LocalDateTimeGenerate localDateTime = new LocalDateTimeGenerate();

    Assert.assertEquals(dateTime, localDateTime.getTimeNow());
  }

  @Test
  public void testAfter4Pm() {
    final String after4Pm = "2021-04-19 16:30";
    LocalDateTime dateTime = LocalDateTime.parse(after4Pm, formatter);
    when(LocalDateTime.now()).thenReturn(dateTime);
    final LocalDateTimeGenerate localDateTime = new LocalDateTimeGenerate();

    Assert.assertEquals(dateTime, localDateTime.getTimeNow());
  }

  @Test
  public void testCurrentTime() {
    final LocalDateTimeGenerate localDateTime = new LocalDateTimeGenerate();

    Assert.assertEquals(LocalDateTime.now(), localDateTime.getTimeNow());
  }

}
