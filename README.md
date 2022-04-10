# SRin23-school-info-security-zip
학교 정보보호 예제 실습 저장소💾

## 개요

학교 정보보안 다중문자치환암호 수행평가

다중문자치환암호를 Spring을 이용하여 구현 예정

## 기획 배경

 학교에서 배운 시저 암호화, 단일 치환 암호화, 다중 문자 치환 암호화 중 다중 문자 치환 암호화를 웹으로 구현함으로써 다소 복잡한 다중 문자 치환 암호의 암호화와 복호화 과정을 한눈에 확인하기 위해서 기획함

 또한 프로그램 언어를 통해 암호화 코드를 구현함으로써 암호화의 내부 프로그램 수행 과정을 분석하여 암호화 기법 중 하나인 다중 문자 치환 암호를 학습하며 학교에서 배운 내용을 복습하기 위해 이를 기획함.

## 사용 언어 및 툴
- html
- css
- javascript
- java
- spring
- intellij

## 입출력 설계

1. **초기화면**
    
    - ‘다중 문자 치환’을 나타내는  ‘PlayFair’이라는 단어를 Title로 하여 초기 화면을 나타냄.
    - 초기화면에는 최근 기록을 보여주는 버튼과, ‘다중 문자 치환’에 대해 설명하는 도움말 버튼, 시작 버튼으로 구성됨

2. **도움말**

    - 도움말에는 ‘다중 문자 치환 암호’가 무엇인지에 대해 나와 있으며, 옆 사진의 내용은 참고용으로 이후 보다 자세하게 내용을 정리할 예정임.

3. **최근 기록**

    - 최근 기록을 보여주는 화면으로  최근 사용한 암호키와 이를 이용하여 변환한 암호문을 약 5~8개 나타낼 예정
    - 이를 통해 사용자는 자신이 최근에 변환한 문장을 확인할 수 있음.

4. **입력화면**
    

    - 입력화면과 출력화면을 나누어 사용자가 입력해야하는 부분과 값을 보여주는 부분을 나눠 헷갈림을 방지함.
    - 입력을 받아야 하는 암호키와 평문을 작성할 수 있는 textbox로 구성

5. **출력화면**
    

    - 암호키를 풀어 표로 나타내고, 사용자가 입력한 평문을 Mapping 한 문장, 이를 변환한 암호키, 평문과 동일한 복호키로 구성됨
    - 또한 Retry 버튼을 눌러 다시 입력화면으로 돌아갈 수 있음

## 기대효과

- 다중 문자 치환 암호화를 웹으로 구현하여 쉽게 알아볼 수 있는 UI를 사용해 이를 사용하는 사람들이 암호화에 대해 관심가질 수 있으며, 다중 문자 치환 암호가 무엇인지 알려주는 도움말 창을 통해 다중문자 치환에 대해 사용자가 알아갈 수 있다. 또한 최근 작성한 암호키와 암호문을 보여줌으로써 보다 사용하기에 사람들이 보다 유용하게 웹사이트를 사용할 수 있을 것으로 기대된다.

- 다중 문자 치환 암호화 구현을 통해 다양한 개발언어를 습득하고, 암호화 코드를 분석함으로써 개발능력 향상의 효과가 있으며, 이후 이를 활용하여 더 유용한 프로그램을 개발할 수 있을 것으로 기대된다.
    
   

## 담당 역할 및 성과

**담당 역할**

- 개인 프로젝트로 암호화/복호화의 모든 과정을 개발
- 메인화면 구현/암호화/복호화/디자인 등

**성과**

## Reference

[Database](https://www.notion.so/Database-8b5341654c8744cf8222b55ac2e61b56)

[API](https://www.notion.so/API-5bf969fa19004c3595a2644a5bdccbb6)
