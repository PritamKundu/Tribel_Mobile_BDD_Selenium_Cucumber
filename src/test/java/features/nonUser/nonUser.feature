Feature: Verify New User Functionality

  @NonUser
  Scenario: TID 001: Check that by clicking on Tribel.com icon the non user will be redirected to Tribel.com home page
    Given Go to Tribel.com
    Then Click on the tribel.com icon


  @NonUser
  Scenario: TID 002: Check if the non user can create new post by clicking on New post button
    Given Go to Tribel.com
    Then Click on "New Post"


  @NonUser
  Scenario: TID 003: Check that the non user can not see the star contributors
    Given Go to Tribel.com
    Then Click on star contributors


  @NonUser
  Scenario: TID 004: Check that the non user is not allowed to see the Groups
    Given Go to Tribel.com
    Then Click on "Groups"


  @NonUser
  Scenario: TID 005: Check that the non-user is not allowed to go to the invite friends page
    Given Go to Tribel.com
    Then Click on "Invite Friends"

  @NonUser
  Scenario: TID 006: Verify that non-users will not be able to see Friends feed
    Given Go to Tribel.com
    Then Click on "Friends"


  @NonUser
  Scenario: TID 007: Verify that non-users will not be able to see Following Feed
    Given Go to Tribel.com
    Then Click on "Following"


  @NonUser
  Scenario: TID 008: Check if the non user can see Breaking Feed posts
    Given Go to Tribel.com
    Then Click on "Breaking" feed posts

  @NonUser
  Scenario: TID 009: Check if the non user can See Trending Feed posts
    Given Go to Tribel.com
    Then Click on "Trending" feed posts

  @NonUser
  Scenario: TID 010: Check if the user is redirected to Trending feed after clicking on Home button
    Given Go to Tribel.com
    Then Click on the "Home" menu

  @NonUser
  Scenario: TID 011: Check if Clicking on Sign in button takes the user to Sign in page
    Given Go to Tribel.com
    Then Click on Sign-in



  @NonUser
  Scenario: TID 012: Check if the non user can like on posts in feed
    Given Go to Tribel.com
    Then Click like on posts in the feed

  @NonUser
  Scenario: TID 013: Check if the non user can comment on any posts
    Given Go to Tribel.com
    Then Click on comment on any posts

  @NonUser
  Scenario: TID 014: Check if the non user can share post on Tribel
    Given Go to Tribel.com
    When Click on posts to share
    Then Click share on tribel

  @NonUser
  Scenario: TID 015: Check if the non user can share post on Facebook
    Given Go to Tribel.com
    When Click on posts to share
    Then Click share on facebook

  @NonUser
  Scenario: TID 016: Check if the non user can see the comments on a post
    Given Go to Tribel.com
    Then Click on comments on a post

  @NonUser
  Scenario: TID 017: Check if the non user can select category in My Favorites
    Given Go to Tribel.com
    When Click on select My Favorites category
    Then Click on personalize your feed, category "Advice" & sub category "Dating"

  @NonUser
  Scenario: TID 018: Check if the non user can select a single category for his feed
    Given Go to Tribel.com
    When Click on select single category
    Then Click on personalize your feed, category "Advice" & sub category "Dating"

  @NonUser
  Scenario: TID 019: Check if the non-user can select everything except in the category
    Given Go to Tribel.com
    When Click on everything except the category
    Then Click on personalize your feed, category "Activism" & sub category "Animal Rescues" for everything except

  @NonUser
  Scenario: TID 020: Check if the non user can clear the selected category for personalized feed
    Given Go to Tribel.com
    When Click on everything except the category
    And Click on personalize your feed, category "Activism" & sub category "Animal Rescues" for everything except
    Then Click on clear all the selected categories for a personalized feed

  @NonUser
  Scenario: TID 021: Verify that as many avatars as the post like list are visible and they are clickable
    Given Go to Tribel.com
    When Click on "Trending" feed posts
    Then Click on the avatar of liked person from posts.

  @NonUser
  Scenario: TID 022: Check if  non user copy link of a post is working properly
    Given Go to Tribel.com
    When Click on "Trending" feed posts
    And  There will show the most trending and breaking posts in those feeds.
    Then Copy the link to the post

  @NonUser @UserProfile
  Scenario Outline: TID 023: Check if the non user can see a user's profile
    Given Go to Tribel.com
    Then Click on a user's profile <feed_username_number>

    Examples:
      | feed_username_number |
      |       0              |
      |       1              |
      |       2              |

  #@NonUser @UserProfile
  Scenario Outline: TID 024: Check if a non user can report a profile
    Given Go to Tribel.com
    When Click on a user's profile <feed_username_number>
    Then Click on user report post from ellipsis icon "<ellipsis_icon_name>", "<Ellipsis_Icon_SubMenu>", "<Report_Violation_Category>", "<Report_to_Tribel_or_Post_Owner>", "I don't see your post !"

    Examples:
      |ellipsis_icon_name| | feed_username_number |      Ellipsis_Icon_SubMenu       |Report_Violation_Category           | Report_to_Tribel_or_Post_Owner |
      |             profile      | |       0              |      Report Profile              |    Contains Nudity                 |           Report to Tribel     |
      #|             0      | |       0              |      Report Profile1              |    Contains Violence               |           Report to Tribel     |
      #|             0      | |       0              |      Report Profile2              |    Contains Harassment             |           Report to Tribel     |
      #|             0      | |       0              |      Report Profile              |    Contains Suicide or Self-Injury |           Report to Tribel     |
      #|             0      | |       0              |      Report Profile              |    Contains False News             |           Report to Tribel     |
      #|             0      | |       0              |      Report Profile              |    Contains Spam                   |           Report to Tribel     |
      #|             0      | |       0              |      Report Profile              |    Contains Unauthorized Sales     |           Report to Tribel     |
      #|             0      | |       0              |      Report Profile              |    Contains Hate Speech            |           Report to Tribel     |
      #|             0      | |       0              |      Report Profile              |    Contains Other                  |           Report to Tribel     |

  @NonUser @UserProfile
  Scenario Outline: TID 025: Check if a non user can report a post in user profile
    Given Go to Tribel.com
    When Click on a user's profile <feed_username_number>
    Then Click on user report post from ellipsis icon "<ellipsis_icon_name>", "<Ellipsis_Icon_SubMenu>", "<Report_Violation_Category>", "<Report_to_Tribel_or_Post_Owner>", "I don't see your post !"

    Examples:
      |ellipsis_icon_name| | feed_username_number |      Ellipsis_Icon_SubMenu       |Report_Violation_Category           | Report_to_Tribel_or_Post_Owner |
      |     post         | |       0              |      Report Post                 |    Contains Nudity                 |           Report to Tribel     |
      #|             0      | |       0              |      Report Profile              |    Contains Violence               |           Report to Tribel     |
      #|             0      | |       0              |      Report Profile              |    Contains Harassment             |           Report to Tribel     |
      #|             0      | |       0              |      Report Profile              |    Contains Suicide or Self-Injury |           Report to Tribel     |
      #|             0      | |       0              |      Report Profile              |    Contains False News             |           Report to Tribel     |
      #|             0      | |       0              |      Report Profile              |    Contains Spam                   |           Report to Tribel     |
      #|             0      | |       0              |      Report Profile              |    Contains Unauthorized Sales     |           Report to Tribel     |
      #|             0      | |       0              |      Report Profile              |    Contains Hate Speech            |           Report to Tribel     |
      #|             0      | |       0              |      Report Profile              |    Contains Other                  |           Report to Tribel     |


  @NonUser @UserProfile
  Scenario Outline: TID 026: Check if a non user can block a person from profile
    Given Go to Tribel.com
    When Click on a user's profile <feed_username_number>
    Then Click on the user profile block from the ellipsis icon "<ellipsis_icon_name>", "<Ellipsis_Icon_SubMenu>"

    Examples:
      | feed_username_number |ellipsis_icon_name|      Ellipsis_Icon_SubMenu       |
      |       0              |     profile      |       Block                      |

  @NonUser @UserProfile
  Scenario Outline: TID 027: Check if a non user can block a person in user profile posts
    Given Go to Tribel.com
    When Click on a user's profile <feed_username_number>
    Then Click on the user posts block from the ellipsis icon "<ellipsis_icon_name>", "<Ellipsis_Icon_SubMenu>"

    Examples:
      | feed_username_number |ellipsis_icon_name|      Ellipsis_Icon_SubMenu       |
      |       0              |     post         |       Block                      |


  @NonUser @UserProfile
  Scenario Outline: TID 028: Check if a non user can copy the link of a post from user profile
    Given Go to Tribel.com
    When Click on a user's profile <feed_username_number>
    Then Copy the link to the post

    Examples:
      | feed_username_number |
      |       0              |

  @NonUser @UserProfile
  Scenario Outline: TID 029: Check if a non user can share on tribel of a post from user profile
    Given Go to Tribel.com
    When Click on a user's profile <feed_username_number>
    And  Click on the share
    Then Click share on tribel

    Examples:
      | feed_username_number |
      |       0              |


  @NonUser @UserProfile
  Scenario Outline: TID 030: Check if a non user can share on facebook of a post from user profile
    Given Go to Tribel.com
    When Click on a user's profile <feed_username_number>
    And  Click on the share
    Then Click share on facebook

    Examples:
      | feed_username_number |
      |       0              |


  @NonUser @UserProfile
  Scenario Outline: TID 031: Check if the non user can like on posts in user profile
    Given Go to Tribel.com
    When Click on a user's profile <feed_username_number>
    Then Click like on posts in the feed

    Examples:
      | feed_username_number |
      |       0              |

  @NonUser @UserProfile
  Scenario Outline: TID 032: Check if the non user can comments on posts in user profile
    Given Go to Tribel.com
    When Click on a user's profile <feed_username_number>
    Then Click on comment on any posts

    Examples:
      | feed_username_number |
      |       0              |


  @NonUser @UserProfile
  Scenario Outline: TID 033: Check if the non user can see comments on posts in user profile
    Given Go to Tribel.com
    When Click on a user's profile <feed_username_number>
    Then Click on comments on a post

    Examples:
      | feed_username_number |
      |       0              |

  @NonUser @UserProfile
  Scenario Outline: TID 034: Check if the non user can comments on posts in user profile
    Given Go to Tribel.com
    When Click on a user's profile <feed_username_number>
    Then Click on user's profile menu "About"

    Examples:
      | feed_username_number |
      |       0              |


  @NonUser @UserProfile
  Scenario Outline: TID 035: Check if the non user can see "Followers" in user profile
    Given Go to Tribel.com
    When Click on a user's profile <feed_username_number>
    Then Click on user's profile menu "Followers"

    Examples:
      | feed_username_number |
      |       0              |

  @NonUser @UserProfile
  Scenario Outline: TID 035: Check if the non user can see "Following" in user profile
    Given Go to Tribel.com
    When Click on a user's profile <feed_username_number>
    Then Click on user's profile menu "Following"

    Examples:
      | feed_username_number |
      |       1              |

  @NonUser @UserProfile
  Scenario Outline: TID 036: Check if the non user can see "Friends" in user profile
    Given Go to Tribel.com
    When Click on a user's profile <feed_username_number>
    Then Click on user's profile menu "Friends"

    Examples:
      | feed_username_number |
      |       1              |