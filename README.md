Math E-Learning Platform with Gamification Elements

An Android mobile application designed to make mathematics engaging and accessible through structured tutorials and interactive math games.

About the Project:
This application was developed as a Bachelor's Degree thesis project at the West University of Timișoara, Faculty of Informatics. The core idea is captured by the motto "Fighting Fire With Fire" — using the same digital tools (mobile apps, games, interactive content) that compete with mathematics for young people's attention, and turning them into vehicles for mathematical learning.
The app is split into two main sections accessible from the home screen: a Tutorial section covering Algebra and Geometry, and a Games section containing 5 interactive math games.

Features:
 User registration and login via Firebase Realtime Database
 Structured math tutorial with 44 Algebra lessons and 33 Geometry lessons
 5 interactive math games covering Algebra, Geometry, Calculus and Trigonometry
 Smart notification system with daily study reminders
 In-app guide explaining every feature and game
 Personal high score tracking for each game
 Fullscreen UI with bounce and zoom animations throughout
 Progress bars tracking lesson completion


Tech Stack:
TechnologyRoleJavaPrimary programming languageAndroid StudioDevelopment environmentXMLUI layout definitionFirebase Realtime DatabaseUser authentication and account data storageSharedPreferencesLocal storage for game scores and notification stateAndroid Canvas / SurfaceViewGame rendering engineAlarmManagerScheduling daily study reminder notifications

Project Structure
com.example.license_project_2/
│
├── MainActivity.java               # Home screen — Tutorial, Games, App Guide
├── Tutorial.java                   # Subject picker — Algebra or Geometry
├── Algebra.java                    # Algebra chapter spinners (7 chapters)
├── AlgebraSection.java             # 4-stage lesson logic for Algebra
├── AlgebraSections.java            # Enum — all 44 Algebra lesson contents
├── Geometry.java                   # Geometry chapter spinners (9 chapters)
├── GeometrySection.java            # 4-stage lesson logic for Geometry
├── GeometrySections.java           # Enum — all 33 Geometry lesson contents
├── Games.java                      # Games hub — navigates to all 5 games
├── LogInActivity.java              # Login screen with Firebase validation
├── SignUpActivity.java             # Registration screen with Firebase storage
├── HelperClass.java                # User data model (POJO)
├── AppGuide.java                   # App guide hub
├── TutorialGuide.java              # Tutorial guide screen
├── GamesGuide.java                 # Games guide hub
├── SpinRouletteGuide.java          # Spin Roulette guide
├── MathShootGuide.java             # Math Shoot guide
├── GeoDodgeGuide.java              # Geo Dodge guide
├── CompleteMathGuide.java          # Complete Math guide
├── TicTacToeMathGuide.java         # TicTacToe Math guide
├── NotificationAdapter.java        # RecyclerView adapter for notifications list
├── NotificationsActivity.java      # Notifications screen
│
├── MathRoulette/
│   └── RouletteMain.java           # Spin Roulette game
│
├── MathShoot/
│   ├── ShootMain.java              # Math Shoot start screen
│   ├── GameActivity.java           # Math Shoot game activity
│   ├── GameView.java               # SurfaceView game loop
│   ├── Flight.java                 # Player plane logic
│   ├── Bullet.java                 # Bullet logic
│   ├── Number.java                 # Target number logic
│   ├── Background.java             # Scrolling background
│   └── GameOverShoot.java          # Game over screen
│
├── MathGeometry/
│   ├── GeometryMain.java           # Geo Dodge start screen
│   ├── GameView.java               # Canvas game loop
│   ├── Figure.java                 # Falling geometric shapes
│   ├── Explosion.java              # Explosion animation
│   └── GameOver.java               # Game over screen
│
├── MathComplete/
│   └── CompleteMain.java           # Complete Math game
│
├── MathTicTacToe/
│   ├── TicTacToeMain.java          # TicTacToe Math game
│   └── GameOverTwo.java            # Game over screen
│
└── notifications/
    ├── NotificationProvider.java       # Interface for notification providers
    ├── NotificationItem.java           # Notification data model
    ├── NotificationRegistry.java       # Aggregates all providers
    ├── NotificationRepository.java     # Persists read/unread state
    ├── NotificationBellHelper.java     # Attaches bell + badge to any activity
    ├── NotificationChannelHelper.java  # Creates Android notification channel
    ├── ReminderScheduler.java          # Schedules AlarmManager alarms
    ├── ReminderReceiver.java           # Receives alarms and fires notifications
    ├── BootReceiver.java               # Reschedules alarms after device reboot
    └── providers/
        ├── DailyStudyReminderProvider.java   # Daily 18:00 study reminder
        ├── TutorialReminderProvider.java     # Algebra & Geometry reminders
        └── GameHighScoreProvider.java        # High score notification

Tutorial Section:
The tutorial is organized into two subjects: Algebra (7 chapters, 44 lessons) and Geometry (9 chapters, 33 lessons).

Algebra Chapters:
  Whole Numbers and Fractions
  Approximate Calculations
  Powers, Roots and Real Numbers
  Expressions
  Equations and Inequalities
  Functions and Graphs
  Arithmetic and Geometric Progressions — Logarithms

Geometry Chapters:
  Fundamental Concepts of Geometry
  Straight Lines
  Circles
  Similarity of Polygons
  Transformation of Figures
  Vectors in the Plane and Trigonometric Functions
  Areas of Polygons
  Regular Polygons, Length of Circumference, Area of a Circle
  Fundamentals of Solid Geometry

Lesson Structure:
Each lesson is divided into 4 sequential stages, navigated using Next / Previous buttons:  
  I. Definition: Read the concept ; Answer an inline question correctly to proceed
  II. Properties: Review key properties ; Answer an inline question correctly to proceed
  III. Worked Examples: Study solved examples ; Answer an inline question correctly to proceed
  IV. Quiz: Solve 5 single-choice questions with images acting as requirements ; Complete all 5 to finish the lesson

Fair warning though, answering the inline question incorrectly resets the current stage — the user must re-read and try again.

All lesson content (theory text, questions, answer options, quiz images, correct answers) is stored in the AlgebraSections and GeometrySections enumerations as Android resource references, completely eliminating code duplication.

Games Section:
The app contains 5 math games, accessible from the Games hub screen (displayed 3 at a time with left/right pagination).

1. Spin Roulette
  A spinning wheel with 4 sectors — Algebra, Geometry, Calculus, Trigonometry — lands on a random subject. A random math problem from that subject is displayed and the user types their answer. Green text = correct, Red text = incorrect.
  
  10 problems per subject (40 total)
  Subjects: Algebra, Geometry, Calculus, Trigonometry
  Animated wheel using RotateAnimation with DecelerateInterpolator

2. Math Shoot
  A side-scrolling shooter where the player controls a plane and shoots at numbers scrolling across the screen.
  
  Left side of screen → move plane up/down
  Right side of screen → shoot bullets
  Hitting a number = +10 points
  Colliding with a number = Game Over
  Implemented on a SurfaceView with a dedicated game thread
  Personal high score saved via SharedPreferences

3. Geo Dodge
  Geometric shapes fall from the top of the screen. The player must dodge them by sliding their character horizontally.
  
  Shapes that reach the bottom explode = +10 points
  Getting hit by a shape = −1 life (3 lives total)
  Health bar changes color: Green → Yellow → Red
  6 possible shape types: circle, square, rectangle, triangle (2 variants), obtuse triangle
  Personal high score saved via SharedPreferences

4. Complete Math
  A sequential word problem game presenting 74 math problems (algebra, fractions, geometry, percentages, probability and more) displayed in pairs.
  
  User types answers in text fields and checks them individually
  Correct answer → text turns green
  Wrong answer → text turns red
  Progress bar advances with each pair completed
  Congratulations screen shown upon completing all 74 problems
  Reset button restarts from problem 1

5. TicTacToe Math
  9 unique numbers (from 1–10) are displayed above a 3×3 grid. The user places numbers into the grid to match 3 target results shown below (one per row).
  
  The operator combination changes every round (16 rotating modes: +, −, ×, ÷ in all combinations)
  Check button evaluates all rows:
  
  Correct row → Blue cells + Green result text → +10 points
  Wrong row → Dark grey cells + Red result text
  
  Each number can only be used once
  Personal high score saved via SharedPreferences


Notification System:
  The notification system uses a provider pattern architecture.
  Providers
  ProviderTypeTriggerTargetDailyStudyReminderProviderPush + In-appDaily at 18:00 if user hasn't opened the app todayTutorial screenTutorialReminderProviderIn-app onlyAlways visibleAlgebra / Geometry screenGameHighScoreProviderIn-app onlyWhen high score > 0Games screen
  Key Components
  
  NotificationBellHelper — attaches a bell icon + unread badge to any activity
  ReminderScheduler — schedules exact daily alarms via AlarmManager, compatible with Android 12+ canScheduleExactAlarms() check
  ReminderReceiver — fires the system notification and self-reschedules for the next day
  BootReceiver — reschedules all alarms after device reboot or app update
  NotificationRepository — persists read/unread state in SharedPreferences


Authentication:
  Authentication is handled via Firebase Realtime Database.
  Sign Up
  Collects: Name, Surname, Username, Email, Password. Stores a HelperClass object under users/{username} in Firebase.
  Log In
  Queries Firebase with orderByChild("username").equalTo(username), then validates the password locally. On success, schedules all notification reminders and navigates to MainActivity.

Database:
  The Database named Firebase Realtime Database is used for user account data (name, surname, username, email, password).
  The Database named SQLite is being used for the saving process of the game entitled "Complete Math".
  The SharedPreferences library is being used for adjusting the game scores for the games "Math Shoot" , "GeoDodge" and "TicTacToe Math", as well as for the notification system.

Installation:
  Clone the repository by using the command, git clone https://github.com/your-username/math-elearning-platform.git

Open the project in Android Studio.
Connect to Firebase:

Go to Firebase Console
Create a new project
Add an Android app with package name com.example.license_project_2
Download google-services.json and place it in the /app directory
Enable Realtime Database in your Firebase project and set the rules to allow read/write during development:

json{
  "rules": {
    ".read": true,
    ".write": true
  }
}

Build and run the project on an Android device or emulator running Android 8.0 (API 26) or higher.


App Usage:
  Launch the app — a 3-second splash screen is displayed.
  Register a new account on the Sign Up screen.
  Log in with your username and password, if you already have one of course.
  
  From the main menu of the app you can choose from the following selection:
    Tutorial → select Algebra or Geometry → choose a chapter → select a lesson → complete all 4 stages
    Games → select one of the 5 math games and play
    App Guide → read how the tutorial and each game works
    Notifications (bell icon) → view and manage your study reminders
