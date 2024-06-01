package behavioural.command;

// Command interface
interface Command {
    void execute();
    void undo();
}

// Receiver
class TextEditor {
    private StringBuilder text = new StringBuilder();

    public void addText(String newText) {
        text.append(newText);
    }

    public void removeText(int length) {
        text.delete(text.length() - length, text.length());
    }

    public String getText() {
        return text.toString();
    }
}

// Concrete Command
class AddTextCommand implements Command {
    private TextEditor editor;
    private String text;
    private int length;

    public AddTextCommand(TextEditor editor, String text) {
        this.editor = editor;
        this.text = text;
        this.length = text.length();
    }

    @Override
    public void execute() {
        editor.addText(text);
    }

    @Override
    public void undo() {
        editor.removeText(length);
    }
}

// Client
public class CommandPatternExample {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Command addText = new AddTextCommand(editor, "Hello, World!");

        addText.execute();
        System.out.println(editor.getText());  // Output: Hello, World!

        addText.undo();
        System.out.println(editor.getText());  // Output: (empty string)
    }
}
