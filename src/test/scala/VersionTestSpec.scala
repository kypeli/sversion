import com.github.sversion.Version
import org.specs2.mutable._

class VersionTestSpec extends Specification{

  "Version >" should {
    "1.2.3 > 1.2.0 == true" in {
      Version("1.2.3") > Version("1.2.0")
    }

    "1.2.RC-3 > 1.2.0 == true" in {
      Version("1.2.RC-3") > Version("1.2.0")
    }

    "1.2.RC-3 > 1.2.RC-2 == true" in {
      Version("1.2.RC-3") > Version("1.2.RC-2")
    }

    "1.2.3.1 > 1.2.3 == true" in {
      Version("1.2.3.1") > Version("1.2.3")
    }

    "1.1.1.1 > 1.2.3 == false" in {
      Version("1.1.1.1") > Version("1.2.3") mustEqual false
    }

    "1.2 > 1.1.1 == true" in {
      Version("1.2") > Version("1.1.1")
    }

    "1.1.1.1 > 1.1.1.1 == false" in {
      Version("1.1.1.1") > Version("1.1.1.1") mustEqual false
    }

    "0.1.24 > 0.1.24 == false" in {
      Version("0.1.24") > Version("0.1.24") mustEqual false
    }

    "1.1.1 > 1 == true" in {
      Version("1.1.1") > Version("1") mustEqual true
    }
  }

  "Version >=" should {
    "1.2.3 >= 1.2.0 == true" in {
      Version("1.2.3") >= Version("1.2.0")
    }

    "1.2.RC-3 >= 1.2.0 == true" in {
      Version("1.2.RC-3") >= Version("1.2.0")
    }

    "1.2.RC-3 >= 1.2.RC-2 == true" in {
      Version("1.2.RC-3") >= Version("1.2.RC-2")
    }

    "1.2.3.1 >= 1.2.3 == true" in {
      Version("1.2.3.1") >= Version("1.2.3")
    }

    "1.1.1.1 >= 1.2.3 == false" in {
      Version("1.1.1.1") >= Version("1.2.3") mustEqual false
    }

    "1.1.1.1 >= 1.1.1.1 == true" in {
      Version("1.1.1.1") >= Version("1.1.1.1")
    }

    "0.1.24 >= 0.1.24 == true" in {
      Version("0.1.24") >= Version("0.1.24") mustEqual true
    }

    "1.1.1 >= 1 == true" in {
      Version("1.1.1") >= Version("1") mustEqual true
    }
  }

  "Version <" should {
    "1.2.3 < 1.2.0 == false" in {
      Version("1.2.3") < Version("1.2.0") mustEqual false
    }

    "1.2.RC-3 < 1.2.0 == false" in {
      Version("1.2.RC-3") < Version("1.2.0") mustEqual false
    }

    "1.2.RC-3 < 1.2.RC-2 == false" in {
      Version("1.2.RC-3") < Version("1.2.RC-2") mustEqual false
    }

    "1.2.3.1 < 1.2.3 == false" in {
      Version("1.2.3.1") < Version("1.2.3") mustEqual false
    }

    "1.1.1.1 < 1.2.3 == true" in {
      Version("1.1.1.1") < Version("1.2.3")
    }

    "0.1.24 < 0.1.24 == false" in {
      Version("0.1.24") < Version("0.1.24") mustEqual false
    }

    "1.1.1 < 1 == false" in {
      Version("1.1.1") < Version("1") mustEqual false
    }
  }

  "Version <=" should {
    "1.2.3 <= 1.2.0 == true" in {
      Version("1.2.3") <= Version("1.2.0") mustEqual false
    }

    "1.2.RC-3 <= 1.2.0 == true" in {
      Version("1.2.RC-3") <= Version("1.2.0") mustEqual false
    }

    "1.2.RC-3 <= 1.2.RC-2 == true" in {
      Version("1.2.RC-3") <=  Version("1.2.RC-2") mustEqual false
    }

    "1.2.3.1 <= 1.2.3 == true" in {
      Version("1.2.3.1") <= Version("1.2.3") mustEqual false
    }

    "1.1.1.1 <= 1.2.3 == false" in {
      Version("1.1.1.1") <= Version("1.2.3")
    }

    "1.1.1.1 <= 1.1.1.1 == true" in {
      Version("1.1.1.1") <= Version("1.1.1.1")
    }

    "0.1.24 <= 0.1.24 == true" in {
      Version("0.1.24") <= Version("0.1.24") mustEqual true
    }

    "1.1.1 <= 1 == false" in {
      Version("1.1.1") <= Version("1") mustEqual false
    }
  }

  "Version ==" should {
    "1.1.0 == 1.1.0 == true" in {
      Version("1.1.0") == Version("1.1.0")
    }

    "1.2.RC-3 == 1.2.RC-3 == true" in {
      Version("1.2.RC-3") == Version("1.2.RC-3")
    }

    "1.2.RC-3 <= 1.2.RC-2 == true" in {
      Version("1.2.RC-3") == Version("1.2.RC-2") mustEqual false
    }

    "1.1.1 == 1.1.0 == false" in {
      Version("1.1.1") == Version("1.1.0") mustEqual false
    }

    "1.1.1 == 1.1 == false" in {
      Version("1.1.1") == Version("1.1") mustEqual false
    }
  }

  "Different length" should {
    "1.1 == 1.1.0" in {
      Version("1.1") == Version("1.1.0")
    }

    "1.1.0 > 1.1" in {
      Version("1.1.0") > Version("1.1") mustEqual false
    }
  }

  "Invalid" should {
    "'' > 1.0 == false" in {
      Version("") > Version("1.0") mustEqual false
    }

    "'nothing' > 1.0 == false" in {
      Version("Nothing") > Version("1.0") mustEqual false
    }
  }

  "Bigger version numbers" should {
    "1.99 > 1.9" in {
      Version("1.99") > Version("1.9")
    }

    "1.10 > 1.9" in {
      Version("1.10") > Version("1.9")
    }
  }

}
