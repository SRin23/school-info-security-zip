package com.srin23.playfair.controller;

import com.srin23.playfair.domain.Playfair;
import com.srin23.playfair.domain.repository.dto.request.DecryptionRequestDto;
import com.srin23.playfair.domain.repository.dto.request.EncryptionRequestDto;
import com.srin23.playfair.domain.repository.dto.response.DelSpaceDto;
import com.srin23.playfair.service.PlayfairService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
처리해야할것
1. 복호시, 추가되었던 X문자 삭제하기
2. 코드 정리
3. mirim 코드 다시 분석하기
 */

@Controller
@RequestMapping("")
public class PlayfairController {
    private PlayfairService playfairService;

    public PlayfairController(PlayfairService playfairService) {
        this.playfairService = playfairService;
    }

    @RequestMapping(value="/")
    public String indexPage(Model model){
        return "index";
    }

    @GetMapping(value="/choice")
    public String choicePage(Model model){
        return "choice";
    }

    @GetMapping(value="/help")
    public String helpPage(Model model){
        return "help";
    }

    @GetMapping(value="/recent")
    public String recentPage(Model model){
        List<Playfair> allRecent = playfairService.findAllRecent();
        if(allRecent.isEmpty()){
            Playfair temp = new Playfair("-", "-", "-");
            allRecent.add(temp);
        }
        model.addAttribute("allRecent", allRecent);
        return "recent";
    }



    @GetMapping(value="/encryption")
    public String encryptionInputPage(Model model){
        model.addAttribute("encryptionRequestDto", new EncryptionRequestDto());
        return "encryptionInput";
    }

    @PostMapping(value="/encryption")
    public String encryptionInputPost(@ModelAttribute("encryptionRequestDto") EncryptionRequestDto encryptionRequestDto, Model model){
        String key = encryptionRequestDto.getEncryptionKey().toUpperCase();
        String plainText = encryptionRequestDto.getPlainText().toUpperCase();
        System.out.println("Key : " + key);
        System.out.println("평문 : " + plainText);

        String noSpaceKey = playfairService.delSpace(key);
        char[][] alphabatBoard = playfairService.setBoard(noSpaceKey);

        System.out.println("알파벳 보드");
        for(int i = 0; i<alphabatBoard.length; i++){
            for(int j = 0; j<alphabatBoard[i].length; j++){
                System.out.print(alphabatBoard[i][j] + " ");
            }
            System.out.println();
        }
        model.addAttribute("alphabatBoard", alphabatBoard);

        DelSpaceDto delSpaceDto = playfairService.DelSpace(plainText);
        String str = delSpaceDto.getStr();
        String zCheck = delSpaceDto.getZCheck();
        String blankCheck = delSpaceDto.getBlankCheck();
//        System.out.println("공백없는 평문 : " + str);
//        System.out.println("zCheck : " + zCheck);
//        System.out.println("blankCheck : " + blankCheck);


        String encryption = playfairService.strEncryption(alphabatBoard, noSpaceKey, str);
//        System.out.println("매핑된 암호문 : " + encryption);
        model.addAttribute("mapping", encryption);

        encryption = playfairService.RealEncryption(encryption);
//        System.out.println("암호문 : " + encryption);
        model.addAttribute("encryption", encryption);

        String decryption = playfairService.strDecryption(alphabatBoard, noSpaceKey, encryption, zCheck);
//        System.out.println("복호문 : " + decryption);


        decryption = playfairService.realDecryption(blankCheck, decryption);
        System.out.println("공백있는 복호문 : " + decryption);

        boolean decryptionCheck = playfairService.finalCheck(plainText, decryption);

        if(decryptionCheck){
            model.addAttribute("decryption", decryption);
            playfairService.saveData(key, plainText, encryption);
        }else{
            model.addAttribute("decryption", "잘못된 값으로 복호되었습니다.");
        }

        System.out.println("복호 여부 : " + playfairService.finalCheck(plainText, decryption));

        return "encryptionOutput";
    }

    @GetMapping(value="/decryption")
    public String decryptionInputPage(Model model){
        model.addAttribute("decryptionRequestDto", new DecryptionRequestDto());
        return "decryptionInput";
    }

    @PostMapping(value="/decryption")
    public String decryptionInputPost(@ModelAttribute("decryptionRequestDto") DecryptionRequestDto decryptionRequestDto, Model model){
        String key = decryptionRequestDto.getEncryptionKey().toUpperCase();
        String encryption = decryptionRequestDto.getEncryption().toUpperCase();
        System.out.println("Key : " + key);
        System.out.println("암호문 : " + encryption);

        String noSpaceKey = playfairService.delSpace(key);
        char[][] alphabatBoard = playfairService.setBoard(noSpaceKey);


        String decryption = playfairService.strDecryption(alphabatBoard, noSpaceKey, encryption, "");
        model.addAttribute("decryption", decryption);

        playfairService.saveData(key, decryption, encryption);
        return "decryptionOutput";
    }
}
