# Create New Account Testing - Sunum

## Slayt 1 - Baslik
**Software Verification and Validation**  
**Create New Account Testing Projesi**  

- Hazirlayan: Seymanur Karakurt
- Ders: SENG324-CENG352
- Tarih: (sunum tarihi)

Konusma notu: Bu projede kayit olma formunun dogrulama kurallarini test otomasyonu ile dogruladim.

---

## Slayt 2 - Odevin Amaci

- Create New Account ozelligini test etmek
- Kullanici hatalarini erken yakalamak
- Testleri otomatik calistirip surekli kalite saglamak

Konusma notu: Hedef sadece calisan kod degil, hataya acik noktalarin sistematik sekilde test edilmesidir.

---

## Slayt 3 - Kullandigim Teknolojiler

- Java 17
- Maven
- JUnit 5
- GitHub Actions

Konusma notu: Maven testleri standart sekilde calistirdi, JUnit ile senaryolari yazdim, GitHub Actions ile CI otomasyonu sagladim.

---

## Slayt 4 - Proje Mimarisi

```text
CreateNewAccountTesting/
├── src/main/java/AccountValidator.java
├── src/test/java/AccountValidatorTest.java
├── .github/workflows/ci.yml
└── pom.xml
```

Konusma notu: Uygulama kurallari ve test kodlari ayrildi; bu sayede bakim ve test edilebilirlik artti.

---

## Slayt 5 - Dogrulama Kurallari

`AccountValidator` icinde kontrol edilenler:

- Ad/Soyad: bos olamaz, 2-50 karakter
- Email: format kontrolu
- Dogum tarihi: yas 18-120 arasi
- Sifre: en az 8 karakter, buyuk-kucuk harf, rakam, ozel karakter
- Confirm Password: eslesme kontrolu

Konusma notu: Formdaki her alan icin gercek hayattaki is kurallarini koda cevirdim.

---

## Slayt 6 - EP Nedir?

**Equivalence Partitioning (Esdeger Bolumleme)**  
Girdileri ayni davranan siniflara boleriz, her siniftan temsilci secip test ederiz.

Email ornegi:
- Gecerli sinif: `test@example.com`
- Gecersiz sinif 1: `testexample.com` (@ yok)
- Gecersiz sinif 2: `test@domain` (uzanti yok)

Konusma notu: Tum kombinasyonlari degil, her davranis sinifini temsil eden ornekleri test ederiz.

---

## Slayt 7 - BVA Nedir?

**Boundary Value Analysis (Sinir Deger Analizi)**  
Kurallarin sinir noktalarini test ederiz.

Yas kurali 18-120 ise:
- 17 (gecersiz)
- 18 (gecerli)
- 19 (gecerli)
- 119 (gecerli)
- 120 (gecerli)
- 121 (gecersiz)

Konusma notu: Hatalar en cok sinir degerlerde ciktigi icin bu teknik kritik onemdedir.

---

## Slayt 8 - Yazdigim Testler

- Toplam 21 JUnit testi
- Gecerli/gecersiz ad, email, sifre senaryolari
- Dogum tarihi sinir deger testleri
- Tum formu birden dogrulayan entegrasyon benzeri testler

Konusma notu: Odevde istenen minimum 15 testin ustune cikarak kapsami genislettim.

---

## Slayt 9 - Otomasyon ve CI

GitHub Actions (`ci.yml`) ile:
- Her push'ta tetiklenir
- JDK 17 kurulur
- `mvn -B test` calisir

Konusma notu: Boylece lokalde unutulsa bile sunucu tarafinda testler otomatik kosar.

---

## Slayt 10 - Sonuclar

- Testler basarili: 21/21
- BUILD SUCCESS
- Proje GitHub'a yuklendi
- CI pipeline aktif

Konusma notu: Teknik olarak hem fonksiyonel test hem de surekli dogrulama tamamlandi.

---

## Slayt 11 - Ne Ogrendim?

- Test tasarim teknikleri: EP ve BVA
- JUnit ile otomatik test yazimi
- Maven ile test yonetimi
- GitHub Actions ile CI kurulumu

Konusma notu: Proje sonunda sadece test yazmak degil, test kulturunu pipeline'a dahil etmeyi ogrendim.

---

## Slayt 12 - Kapanis

Tesekkur ederim.  
Sorularinizi alabilirim.

---

## Q&A Hazir Cevaplar

**Soru: Neden EP kullandin?**  
Cevap: Tum girdileri tek tek denemek yerine davranis siniflarini test ederek daha az testle daha yuksek kapsama aldim.

**Soru: Neden BVA kullandin?**  
Cevap: Hatalarin buyuk kismi sinir degerlerde ciktigi icin 18-120 gibi kurallarda sinir etrafinda test yazdim.

**Soru: Neden CI ekledin?**  
Cevap: Her kod degisikliginde testlerin otomatik kosmasi kaliteyi surekli guvence altina aliyor.

**Soru: Bu unit test mi?**  
Cevap: Evet, agirlikla unit test. Son kisimda tum alanlari birlikte kontrol eden testler de var.
