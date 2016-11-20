# n11-challange

n11 spring boot challange : https://n11app-ozgurdemirel.herokuapp.com

http://start.spring.io/ kullanarak projeyi oluşturdum.

common paketinin altında ;
	exception : custom exceptionlar
	model  : ResultWrapper sınıfı custom pojo
	util : Tamsayıdan Roma rakamlarına ceviren util
converter paketinin altında ;
	contoller : rest endpoint implementasyonu
	service : rest ve repository arasındaki katman validasyonu burada yapıyorum.
	repository : şimdilik util classını kullanıyor ama db de olabilirdi.

#Unit testler 

mockito ve junit kullandım.
Integration testler için base bir class oluşturdum.
com.n11.converter.controller.RomanNumeralControllerIT : Integration testtir.

diğer hepsi unit test olarak yazılmıştır.

#java-doc 
java-doclar yazılmıştır.
#css
bootstrap css starter template ' ini  kullandım.
	