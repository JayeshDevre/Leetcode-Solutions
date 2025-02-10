import pandas as pd

def selectFirstRows(employees: pd.DataFrame) -> pd.DataFrame:
    return pd.DataFrame(employees.head(3))
    