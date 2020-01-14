package com.example.smartgk.utitlies;

import com.example.smartgk.Database.BookData;
import com.example.smartgk.model.BooksModel;

import org.json.JSONException;

import java.util.List;

public class JsonUtils {
    public static BookData[] getBookObjectsFromJson(List<BooksModel.Results> resultsList)
        throws JSONException{
        BookData[] bookDatas = new BookData[resultsList.size()];
        BookData bookData;

        for (int i =0; i<resultsList.size(); i++){
        BooksModel.Results results =resultsList.get(i);
    String title = results.getTitle();
    String description = results.getDescription();
    String author= results.getAuthor();
    String alt_image= results.getAlt_image();
    String publisher = results.getPublisher();
    String price = results.getPrice();
    String pages = results.getPages();
    String status = results.getStatus();
    String image = results.getImage();
    String created_at = results.getCreated_at();
    String updated_at = results.getUpdated_at();

            bookData = new BookData(i+1,title,
                    description, author, alt_image, publisher, price, pages, status, image, created_at, updated_at);
            bookDatas[i] = bookData;
        }
        return bookDatas;
    }
}
