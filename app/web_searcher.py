import requests
from bs4 import BeautifulSoup

def search_web(query):
    """Perform a simple web search and extract a clean summary."""
    headers = {
        "User-Agent": "Mozilla/5.0"
    }
    try:
        response = requests.get(f"https://www.google.com/search?q={query}", headers=headers)
        soup = BeautifulSoup(response.text, "html.parser")

        # Try to find the featured snippet or top result
        answer = soup.find("div", class_="BNeawe").text
        return answer.strip() if answer else "Sorry, I couldn't find anything useful."
    except Exception as e:
        return f"Error during web search: {str(e)}"
