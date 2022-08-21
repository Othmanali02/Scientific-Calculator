package application;

import java.util.Arrays;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Main extends Application {
	TextField input = new TextField();
	TextField postfix = new TextField();
	TextField result = new TextField();
	
	public static boolean isNumeric(String c) {
		try {
			Double.parseDouble(c + "");
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
	
		
		input.setPrefHeight(50);
		input.setFont(Font.font(20));
		input.setAlignment(Pos.TOP_LEFT);
		input.setFont(Font.loadFont("file:src/PixelMplus12-Regular.ttf", 23));
		input.setEditable(false);
		input.setStyle("-fx-background-color: #5fdad5, #ffffff;\r\n" + "-fx-background-insets: 0, 2 0 0 0 ;");

		postfix.setPrefHeight(50);
		postfix.setFont(Font.font(20));
		postfix.setAlignment(Pos.TOP_LEFT);
		postfix.setTranslateY(51.5);
		postfix.setFont(Font.loadFont("file:src/PixelMplus12-Regular.ttf", 23));
		
		postfix.setEditable(false);
		postfix.setStyle("-fx-background-color: #5fdad5, #ffffff;\r\n" + "-fx-background-insets: 0, 2 0 0 0 ;");

		result.setPrefHeight(30);
		result.setFont(Font.font(20));
		result.setAlignment(Pos.TOP_LEFT);
		result.setFont(Font.loadFont("file:src/PixelMplus12-Regular.ttf", 23));
		result.setTranslateY(100);
		result.setEditable(false);

		result.setStyle("-fx-background-color: #5fdad5, #ffffff;\r\n" + "-fx-background-insets: 0, 2 0 0 0 ;");

		StackPane stackPane = new StackPane();

//		Button Equal = new Button("=");
//		Equal.setPrefSize(100, 60);
//		Equal.setTranslateY(490);

		stackPane.setPadding(new Insets(10));
		stackPane.getChildren().add(input);
		stackPane.getChildren().add(postfix);
		stackPane.getChildren().add(result);
		// stackPane.getChildren().add(Equal);

		TilePane tile = new TilePane();
		tile.setTranslateY(90);
		tile.setHgap(10);
		tile.setVgap(10);
		tile.setAlignment(Pos.TOP_CENTER);
		tile.getChildren().addAll(createButtonForSymbol("sin"), createButtonForSymbol("cos"),
				createButtonForSymbol("tan"), createButtonForOpen("("), createButtonForClose(")"),
				createButtonForClose("!"), createButtonForOff("OFF"), createButtonForNumber("π"),
				createButtonForPower("^"), createButtonForNumber("7"), createButtonForNumber("8"),
				createButtonForNumber("9"), createButtonForOperator("/"), createButtonForNegation("(-)"),
				createButtonForOperator("^ 2"), createButtonForRoot("√"), createButtonForNumber("4"),
				createButtonForNumber("5"), createButtonForNumber("6"), createButtonForOperator("*"),
				createButtonForClear("CA"), createButtonForSymbol("e ^"), createButtonForSymbol("LN"),
				createButtonForNumber("1"), createButtonForNumber("2"), createButtonForNumber("3"),
				createButtonForOperator("-"), createButtonForClearSpace("C"), createButtonForSymbol("log"),
				createButtonForSymbol("1 /"), createButtonForNumber("0"), createButtonForPeriod("."),
				createButtonForOperator("%"), createButtonForOperator("+"), createButtonForDelete("Del"),
				createEqualButton(" "));

		Image img2 = new Image("HewwoKitty.jpg", 420, 720, false, false);
		BackgroundImage bImg1 = new BackgroundImage(img2, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background bGround1 = new Background(bImg1);
		root.setBackground(bGround1);// main screen

		root.setTop(stackPane);
		root.setCenter(tile);
		Scene scene = new Scene(root, 420, 700);
		primaryStage.getIcons().add(new Image("file:src/Hello-Kitty-png-HD-removebg-preview.png"));

		primaryStage.setTitle("Hello Kitty Calculator - Othman Ali - 1202927");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private Button createButtonForOff(String ch) {
		Button button = new Button(ch);
		button.setPrefSize(50, 50);
		button.setStyle("-fx-background-color:#FF5F1F;\r\n" + "    -fx-background-radius:0;\r\n"
				+ "    -fx-border-color:black;\r\n" + "    -fx-border-width: 0 3 3 0;\r\n"
				+ "    -fx-background-insets: 0;");
		button.setTextFill(Color.WHITE);
		button.setFont(Font.loadFont("file:src/PixelMplus12-Bold.ttf", 15));

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Platform.exit();
			}
		});
		return button;
	}

	private Button createButtonForDelete(String ch) {
		Button button = new Button(ch);
		button.setPrefSize(50, 50);
		button.setStyle("-fx-background-color:#152238;\r\n" + "    -fx-background-radius:0;\r\n"
				+ "    -fx-border-color:black;\r\n" + "    -fx-border-width: 0 3 3 0;\r\n"
				+ "    -fx-background-insets: 0;");
		button.setTextFill(Color.WHITE);
		button.setFont(Font.loadFont("file:src/PixelMplus12-Bold.ttf", 15));

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String del = input.getText();
				
				if (!del.equals("")) {
//					for(int i = del.length() - 1; i >= 0 ; i--) {
//						if(del.charAt(i) == ' ')
//							del.substring(0 , del.length() - 2);
//						else
							del = del.substring(0 , del.length() - 1).strip();
					
				} else {
					input.setText("");
				}

				input.setText(del);
			}
		});
		return button;
	}

	private Button createButtonForOperator(String ch) {
		Button button = new Button(ch);
		button.setPrefSize(50, 50);
		button.setStyle("-fx-background-color:#fefefe;\r\n" + "    -fx-background-radius:0;\r\n"
				+ "    -fx-border-color:black;\r\n" + "    -fx-border-width: 0 3 3 0;\r\n"
				+ "    -fx-background-insets: 0;");
		button.setTextFill(Color.BLACK);
		button.setFont(Font.loadFont("file:src/PixelMplus12-Bold.ttf", 16.5));

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				input.setText(input.getText() + " " + ch + " ");
			}
		});
		return button;
	}

	private Button createButtonForNegation(String ch) {
		Button button = new Button(ch);
		button.setPrefSize(50, 50);
		button.setStyle("-fx-background-color:#D2042D;\r\n" + "    -fx-background-radius:0;\r\n"
				+ "    -fx-border-color:black;\r\n" + "    -fx-border-width: 0 3 3 0;\r\n"
				+ "    -fx-background-insets: 0;");
		button.setTextFill(Color.WHITE);
		button.setFont(Font.loadFont("file:src/PixelMplus12-Bold.ttf", 16));

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				input.setText(input.getText() + "-");
			}
		});
		return button;
	}

	private Button createButtonForSymbol(String ch) {
		Button button = new Button(ch);
		button.setPrefSize(50, 50);
		button.setStyle("-fx-background-color:#fefefe;\r\n" + "    -fx-background-radius:0;\r\n"
				+ "    -fx-border-color:black;\r\n" + "    -fx-border-width: 0 3 3 0;\r\n"
				+ "    -fx-background-insets: 0;");
		button.setTextFill(Color.BLACK);
		button.setFont(Font.loadFont("file:src/PixelMplus12-Bold.ttf", 16));

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				input.setText(input.getText() + ch + " ( ");					
			}
		});
		return button;
	}

	private Button createButtonForPower(String ch) {
		Button button = new Button(ch);
		button.setPrefSize(50, 50);
		button.setStyle("-fx-background-color:#fefefe;\r\n" + "    -fx-background-radius:0;\r\n"
				+ "    -fx-border-color:black;\r\n" + "    -fx-border-width: 0 3 3 0;\r\n"
				+ "    -fx-background-insets: 0;");
		button.setTextFill(Color.BLACK);
		button.setFont(Font.loadFont("file:src/PixelMplus12-Bold.ttf", 23));

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				input.setText(input.getText() + " " + ch + " ( ");
			}
		});
		return button;
	}

	private Button createButtonForRoot(String ch) {
		Button button = new Button(ch);
		button.setPrefSize(50, 50);
		button.setStyle("-fx-background-color:#fefefe;\r\n" + "    -fx-background-radius:0;\r\n"
				+ "    -fx-border-color:black;\r\n" + "    -fx-border-width: 0 3 3 0;\r\n"
				+ "    -fx-background-insets: 0;");
		button.setTextFill(Color.BLACK);
		button.setFont(Font.loadFont("file:src/PixelMplus12-Bold.ttf", 16));

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				input.setText(input.getText() + ch + " ( ");
			}
		});
		return button;
	}

	private Button createButtonForOpen(String ch) {
		Button button = new Button(ch);
		button.setPrefSize(50, 50);
		button.setStyle("-fx-background-color:#fefefe;\r\n" + "    -fx-background-radius:0;\r\n"
				+ "    -fx-border-color:black;\r\n" + "    -fx-border-width: 0 3 3 0;\r\n"
				+ "    -fx-background-insets: 0;");
		button.setTextFill(Color.BLACK);
		button.setFont(Font.loadFont("file:src/PixelMplus12-Bold.ttf", 19));

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				input.setText(input.getText() + ch + " ");
			}
		});
		return button;
	}

	private Button createButtonForClose(String ch) {
		Button button = new Button(ch);
		button.setPrefSize(50, 50);
		button.setStyle("-fx-background-color:#fefefe;\r\n" + "    -fx-background-radius:0;\r\n"
				+ "    -fx-border-color:black;\r\n" + "    -fx-border-width: 0 3 3 0;\r\n"
				+ "    -fx-background-insets: 0;");
		button.setTextFill(Color.BLACK);
		button.setFont(Font.loadFont("file:src/PixelMplus12-Bold.ttf", 19));

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				input.setText(input.getText() + " " + ch);
			}
		});
		return button;
	}

	private Button createButtonForClear(String ch) {
		Button button = new Button(ch);
		button.setPrefSize(50, 50);
		button.setStyle("-fx-background-color:#ffd300;\r\n" + "    -fx-background-radius:0;\r\n"
				+ "    -fx-border-color:black;\r\n" + "    -fx-border-width: 0 3 3 0;\r\n"
				+ "    -fx-background-insets: 0;");
		button.setTextFill(Color.WHITE);
		button.setFont(Font.loadFont("file:src/PixelMplus12-Bold.ttf", 19));
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				input.setText("");
				postfix.setText("");
				result.setText("");
			}
		});
		return button;
	}

	private Button createButtonForClearSpace(String ch) {
		Button button = new Button(ch);
		button.setPrefSize(50, 50);
		button.setStyle("-fx-background-color:#00FF00;\r\n" + "    -fx-background-radius:0;\r\n"
				+ "    -fx-border-color:black;\r\n" + "    -fx-border-width: 0 3 3 0;\r\n"
				+ "    -fx-background-insets: 0;");
		button.setTextFill(Color.WHITE);
		button.setFont(Font.loadFont("file:src/PixelMplus12-Bold.ttf", 19));

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (input.getText() != null) {
					String[] lastsplit = input.getText().split(" ");
					lastsplit = Arrays.copyOf(lastsplit, lastsplit.length - 1);
					String result = "";
					for (int i = 0; i < lastsplit.length; i++) {
						result += lastsplit[i] + " ";
					}
					input.setText(result);
				} else {
					input.setText("");
				}

			}
		});
		return button;
	}

	public Button createButtonForNumber(String ch) {
		Button button = new Button(ch);
		button.setPrefSize(50, 50);
		button.setStyle("-fx-background-color:#fefefe;\r\n" + "    -fx-background-radius:0;\r\n"
				+ "    -fx-border-color:black;\r\n" + "    -fx-border-width: 0 3 3 0;\r\n"
				+ "    -fx-background-insets: 0;");
		button.setTextFill(Color.BLACK);
		button.setFont(Font.loadFont("file:src/PixelMplus12-Bold.ttf", 19));

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				input.setText(input.getText() + ch);
			}
		});

		return button;
	}

	public Button createButtonForPeriod(String ch) {
		Button button = new Button(ch);
		button.setPrefSize(50, 50);
		button.setStyle("-fx-background-color:#fefefe;\r\n" + "    -fx-background-radius:0;\r\n"
				+ "    -fx-border-color:black;\r\n" + "    -fx-border-width: 0 3 3 0;\r\n"
				+ "    -fx-background-insets: 0; -fx-font-weight:bold; -fx-font-size:20; fx-color:white");
		button.setTextFill(Color.BLACK);
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				input.setText(input.getText() + ch);

			}
		});

		return button;
	}

	public Button createEqualButton(String ch) {
		Button button = new Button(ch);
		button.setPrefSize(50, 50);
		Image img = new Image("ab8d905edd3dc043ff916db56a90027b--hello-kitty-tattoos-hello-kitty-wallpaper.jpg", 50, 50, true, true);

		BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,//Setting the background for every scene
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background bGround = new Background(bImg);
	
		button.setBackground(bGround);
		button.setFont(Font.loadFont("file:src/PixelMplus12-Bold.ttf", 19));
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (input.getText().equals("")) {
					result.setText("0.0");
					postfix.setText("0");
				} else {

					String postEquation = "";
					if (!infixToPostfix(input.getText().replaceAll("e", Math.E + "").replaceAll("π", Math.PI + "")
							.replace("--", "").trim().replaceAll("\\s{2,}", " ")).contains("(")) {
						postEquation = infixToPostfix(input.getText().replaceAll("e", Math.E + "")
								.replaceAll("π", Math.PI + "").replace("--", "").trim().replaceAll("\\s{2,}", " "));
						postfix.setText(postEquation);
					} else if (infixToPostfix(input.getText()).contains("(")) {
						System.out.println(infixToPostfix(input.getText()));
						postfix.setText("Invalid Infix: Brackets are not Balanced");
						result.setText("Error");
					}

					try {
						CursorStack<Double> Evaluate = new CursorStack<>();

						String[] split = postEquation.split(" ");
						
						for (int i = 0; i < split.length; i++) {
							System.out.println(split[i]);
							if (split[i] == null) {
								break;
							}
							if (isNumeric(split[i])) {
								Evaluate.push(Double.parseDouble(split[i]));
							} else {
								if (split[i].equals("^") || split[i].equals("+") || split[i].equals("-")
										|| split[i].equals("*") || split[i].equals("/") || split[i].equals("%")) {

									double first = Evaluate.pop();
									double second = Evaluate.pop();

									switch (split[i]) {

									case "+":
										Evaluate.push(second + first);
										break;

									case "-":
										Evaluate.push(second - first);
										break;

									case "/":
										Evaluate.push(second / first);
										break;

									case "*":
										Evaluate.push(second * first);
										break;

									case "^":
										Evaluate.push(Math.pow(second, first));
										break;
									case "%":
										Evaluate.push(second % first);
										break;
									}
								} else {
									double first = Evaluate.pop();

									switch (split[i]) {
									case "√":
										Evaluate.push(Math.sqrt(first));
										break;
									case "sin":
										Evaluate.push(Math.sin(first));//for trigonometry to be in Degree instead of radian
										break;							//just replace (first) with (first * (Math.PI / 180))
									case "cos":
										Evaluate.push(Math.cos(first));
										break;
									case "tan":
										Evaluate.push(Math.tan(first));
										break;
									case "log":
										Evaluate.push(Math.log1p(first));
										break;
									case "LN":
										Evaluate.push(Math.log(first));
										break;
									case "!":
										Evaluate.push(factorial(first));
										break;
									case "-√":
										Evaluate.push(-Math.sqrt(first));
										break;
									case "-sin":
										Evaluate.push(-Math.sin(first));
										break;
									case "-cos":
										Evaluate.push(-Math.cos(first));
										break;
									case "-tan":
										Evaluate.push(-Math.tan(first));
										break;
									case "-log":
										Evaluate.push(-Math.log1p(first));
										break;
									case "-LN":
										Evaluate.push(-Math.log(first));
										break;
									}
								}
							}
						}

						if (Evaluate.peek().toString().equals("Infinity")) {
							result.setText("Math Error: Dividing by Zero");
						} else {
							result.setText(Evaluate.peek().toString());
						}
						if (Evaluate.peek().toString().equals("NaN")) {
							result.setText("Math ERROR: CA: Clear All");
						} else {
							result.setText(Evaluate.peek().toString());
						}
						
//						if (Evaluate.peek().toString().equals("Infinity")) {
//							result.setText("Math Error: Dividing by Zero");
//						} else {
//							result.setText(Evaluate.peek().toString());
//						}

					} catch (Exception ex) {
						result.setText("Syntax ERROR [CA] : Clear All");
						System.out.println(ex + "171");
					} catch(StackOverflowError stack) {
						result.setText("Syntax ERROR [CA] : Clear All");

					}

				}

			}

		});

		return button;
	}

	public double factorial(double input) {
		if (input == 0)
			return 1;
		else
			return (input * factorial(input - 1));
	}

	public static String infixToPostfix(String infix) {
		String post = "";
		CursorStack<String> stack = new CursorStack<String>();
		String[] split = infix.split(" ");

		for (int i = 0; i < split.length; i++) {
			if (split[0] == null) {
				post += "";
			}
			if (isNumeric(split[i])) {// checks whether it is a number and adds it to the result
				post += split[i] + " ";
			} else if (split[i].equals("(")) {// pushes '(' to the stack
				stack.push(split[i]);
			} else if (split[i].equals(")")) {// if it is a ')' append to the output until '(' is spotted or stack is
				// empty
				while (!stack.isEmpty() && !stack.peek().equals("(")) {
					post += stack.pop() + " ";// adds the
				}
				stack.pop();
			}
//			else if (split[i].equals("(-)") && isNumeric(split[i + 1])) {
//				post += "-";
//			} else if (split[0].equals("(-)") && isNumeric(split[1]) && i == 0) {
//				post += "-" + split[1];
//			} else if (split[i].equals("(-)") && Precedence(split[i + 1]) != -1) {
//				split[i + 1] = "-" + split[i + 1];
//			} 
			else {// this checks for the order of the operation
				while (!stack.isEmpty() && Precedence(split[i]) <= Precedence(stack.peek())) {
					post += stack.pop() + " ";// appends the operator to the result statement
				}
				stack.push(split[i]);// adds the operator to the stack
			}

		}

		while (!stack.isEmpty()) {
			if (stack.peek() == "(")
				return null;
			post += stack.pop() + " ";// appends whatever operator is left in the stack
		} // as long as the stack is empty and no ( is encountered

		return post.trim().replaceAll("\\s{2,}", " ");
	}

	static int Precedence(String ch) {
		switch (ch) {
		case "+":
			return 1;
		case "-":
			return 1;
		case "*":
			return 2;
		case "/":
			return 2;
		case "%":
			return 3;
		case "^":
			return 4;
		case "√":
			return 3;
		case "sin":
			return 3;
		case "cos":
			return 3;
		case "tan":
			return 3;
		case "log":
			return 3;
		case "LN":
			return 3;
		case "-√":
			return 3;
		case "-sin":
			return 3;
		case "-cos":
			return 3;
		case "-tan":
			return 3;
		case "-log":
			return 3;
		case "-LN":
			return 3;
		case "!":
			return 4;
		default:
			return -1;
		}
	}

	public static String addChar(String str, char ch, int position) {
		int len = str.length();
		char[] updatedArr = new char[len + 1];
		str.getChars(0, position, updatedArr, 0);
		updatedArr[position] = ch;
		str.getChars(position, len, updatedArr, position + 1);
		return new String(updatedArr);
	}

	public static void main(String[] args) {
		launch(args);
	}
}