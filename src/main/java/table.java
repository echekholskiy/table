import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class table {
    private WebElement tableElement;
    private WebDriver driver;

    public table(WebElement tableElement, WebDriver driver){
        this.tableElement=tableElement;
        this.driver=driver;
    }

    public List<WebElement> getRows(){
        List<WebElement> rows=tableElement.findElements(By.xpath(".//tr"));
        rows.remove(0);
        return rows;
    }
    public List<WebElement> getHeadings(){
        WebElement headingsrow=tableElement.findElement(By.xpath(".//tr[1]"));
        List<WebElement> headingcolums=headingsrow.findElements(By.xpath(".//th"));
        return headingcolums;
    }
    public List<List<WebElement>> getRowsWithColums(){
        List<WebElement> rows=getRows();
        List<List<WebElement>> rowsWithColumns=new ArrayList<List<WebElement>>();
        for(WebElement row:rows){
            List<WebElement> rowWithColumns=row.findElements(By.xpath(".//td"));
            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;

    }
    public List<Map<String, WebElement>> getrowswithcolumnsbyheadings(){
        List<List<WebElement>> rowswithcolumn=getRowsWithColums();
        List<Map<String, WebElement>> rowswithcolumnsbyheadings=new ArrayList<Map<String, WebElement>>();
        Map<String, WebElement> rowbyheading;
        List<WebElement> headings=getHeadings();
        for(List<WebElement> row:rowswithcolumn){
            rowbyheading=new HashMap<String, WebElement>();
            for(int i=0; i<headings.size(); i++){
                String heading=headings.get(i).getText();
                WebElement cell=row.get(i);
                rowbyheading.put(heading, cell);

            }
            rowswithcolumnsbyheadings.add(rowbyheading);
        }
        return rowswithcolumnsbyheadings;
    }

    public String getValueFromCell(int rowNumber, int ColumnNumber){
        List<List<WebElement>> rowswithcolumn=getRowsWithColums();
        List<WebElement> row=rowswithcolumn.get(rowNumber-1);
        WebElement cell=row.get(ColumnNumber-1);
        return cell.getText();
    }

    public String getValueFromCell(int rowNumber, String ColumnName){
        List<Map<String, WebElement>> rowswithcolumnsbyheadings=getrowswithcolumnsbyheadings();
        return rowswithcolumnsbyheadings.get(rowNumber-1).get(ColumnName).getText();

    }

}
